/**
 * Tibero, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.processor;

import com.tmax.hyperdata.util.TbHdSession;
import org.apache.xmlbeans.XmlObject;

import com.tmax.hyperdata.error.TbHdException;
import com.tmax.tbhub.request.UserInfoDocument.UserInfo;
import com.tmax.tbhub.response.ResponseDocument;

import java.sql.Connection;

/**
 * @author YunWooPark (yunwoo_park@tibero.com) 2014. 4. 15.
 * @version $Id: ITbHyperDataRequestProcessor.java 11 2017-12-07 03:24:29Z taebo $
 */

/**
 * Request processor의 기본 원형.
 */
public interface ITbHyperDataRequestProcessor {
    /**
     * 모든 request processor의 작업 수행.
     *
     * @param hyperdataSession
     *
     * @param userInfo
     *            Request XML을 통해 넘어온 {@link UserInfo}.
     * @param requestEnum
     *            {@link ETbHyperDataRequest} enumeration.
     * @param requestXmlObj
     *            Request XML을 통해 넘어온 실제 request body.
     * @return Request 처리 결과
     */
    public ResponseDocument process(TbHdSession hyperdataSession,
                                    UserInfo userInfo,
                                    ETbHyperDataRequest requestEnum,
                                    XmlObject requestXmlObj)
            throws TbHdException;
}