package com.tmax.hyperdata.processor;

import com.tmax.hyperdata.util.TbHdSession;
import com.tmax.tbhub.response.ResponseDocument.Response;
import com.tmax.tbhub.response.ResponseDocument;
import com.tmax.tibero.jdbc.ext.TbDataSource;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

import com.m.msl.logger.MLogger;
import com.tmax.hyperdata.error.TbHdError;
import com.tmax.hyperdata.error.TbHdException;
import com.tmax.tbhub.request.RequestDocument;
import com.tmax.tbhub.request.RequestDocument.Request;
import com.tmax.tbhub.request.UserInfoDocument.UserInfo;
import com.tmax.tbhub.response.TResult;
import com.tmax.tbhub.response.TResultData;
import com.tmax.tbhub.response.ErrorDocument.Error;

import java.sql.Connection;

public class TbHdRequestParser {
    private  static TbDataSource hdDs;

    public String parseAndExecute(String header, String body) {
        MLogger.TRACE("request=" + header + body);

        String response = null;

        RequestDocument requestDoc = null;
        ResponseDocument responseDoc = null;

        // Header 파싱 ..?

        Connection conn = null;
        TbHdSession hyperdataSession = null;

        // po에서 들어온 정보로 getConnection.

        hyperdataSession = new TbHdSession("sessionId", conn);

        try {
            try {
                requestDoc = RequestDocument.Factory.parse(body);
            }
            catch (XmlException e) {
                MLogger.ERROR(e);
                throw new TbHdException(TbHdError.PARSE_FAIL_XML);
            }

            responseDoc = parseAndExecuteInternal(hyperdataSession, requestDoc);
        }
        catch (TbHdException e) {
            responseDoc = responseFailure(e);
        }

        // res -> json -> string (resDoc 포장 작업)


        return response;
    }

    private XmlObject getXmlObjectofRequest(Request request) throws TbHdException {
        MLogger.TRACE("request=" + request);

        XmlCursor xmlCursor = null;
        XmlObject[] xmlObjs;

        try {
            xmlCursor = request.newCursor();

            String xPath = "declare namespace req='" + xmlCursor.getName().getNamespaceURI() + "';$this/*";
            xmlObjs = request.selectPath(xPath);

            MLogger.DEBUG("Need 2 XML objects. (UserInfo + Request Body)");
            if(xmlObjs.length != 2) {
                throw new TbHdException(TbHdError.PARSE_FAIL_XML, "Need 2 XML objects. (UserInfo + Request Body)");
            }

        }
        finally {
            xmlCursor.dispose();
        }

        return xmlObjs[1];
    }

    private ResponseDocument parseAndExecuteInternal(TbHdSession hyperdataSession, RequestDocument requestDoc) throws TbHdException {
        MLogger.TRACE("requestDoc=" + requestDoc);

        Request request = requestDoc.getRequest();

        /* 사용자 정보 */
        UserInfo userInfo = request.getUserInfo();
        MLogger.INFO("User Information:");
        MLogger.INFO("ID = " + userInfo.getUserId());
        MLogger.INFO("NAME = " + userInfo.getUserName());

        XmlObject requestXml = getXmlObjectofRequest(request);

        String reqName = null;
        XmlCursor xmlCursor = null;
        try {
            xmlCursor = requestXml.newCursor();
            reqName = xmlCursor.getName().getLocalPart();
            MLogger.DEBUG("REQUEST NAME : " + reqName);
        }
        finally {
            xmlCursor.dispose();
        }

        /* Request에 해당하는 enumeration 구하기. */
        ETbHyperDataRequest requestEnum = ETbHyperDataRequest.getEnum(reqName);
        if (null == requestEnum) {
            String msg = '(' + reqName + ')';
            MLogger.ERROR(TbHdError.getFullMsg(TbHdError.NOT_FOUND_REQUEST) +
                    msg);
            throw new TbHdException(TbHdError.NOT_FOUND_REQUEST, msg);
        }
        else {
            MLogger.INFO("Request = " + requestEnum.toString());
        }

        /* JYS
        * 권한 체크 필요한 부분인가 ???
        * */

        /* Request processor 수행. */
        ResponseDocument responseDoc = null;
        try {
            responseDoc = requestEnum.getProcessor().process(hyperdataSession, userInfo, requestEnum, requestXml);
        }
        catch (TbHdException e) {
            throw e;
        }
        catch (Exception e) {
            MLogger.ERROR(e);
            throw new TbHdException(TbHdError.FAIL_REQUEST_PROCESS,
                    e.getMessage());
        }
        MLogger.DEBUG("Completing the request.");

        return responseDoc;
    }

    private ResponseDocument responseFailure(TbHdException e) {
        MLogger.TRACE("e=" + e);

        /* Failure response 생성. */
        ResponseDocument responseDoc = ResponseDocument.Factory.newInstance();
        Response response = responseDoc.addNewResponse();
        response.setResult(TResult.FAILURE);
        TResultData resultData = response.addNewResultData();
        Error error = resultData.addNewError();
        error.setCode(e.getErrorCode());
        error.setDesc(e.toString());

        return responseDoc;
    }
}