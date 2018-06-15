package com.tmax.hyperdata.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlCursor.TokenType;

import com.tmax.tbhub.header.ConstraintValue;
import com.tmax.tbhub.header.TExternalParameter;
import com.tmax.tbhub.header.TGranteeType;

/**
 * @author HongsuRyu (hongsu_ryu@tmaxdata.com) 2015. 6. 26.
 * @version $Id: XMLUtil.java 11 2017-12-07 03:24:29Z taebo $
 */

/**
 * FIXME class description.
 */
public class XMLUtil {

    
    public static final String PREVIOUS_TASK_INDICATOR = ConstraintValue.Factory
            .newInstance().getAdhocPreviousTask();
    public static String dateToString(Calendar cal) {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String date = transFormat.format(cal.getTime());
        return date;
    }

    public static String getMixedContentValue(TExternalParameter obj) {
        String result = null;
        XmlCursor cursor = obj.newCursor();
        try {
            boolean attrExist = false;
            int tokenType;
            while ((tokenType = cursor.currentTokenType()
                    .intValue()) != TokenType.INT_END &&
                    tokenType != TokenType.INT_TEXT) {
                if (tokenType == TokenType.INT_ATTR)
                    attrExist = true;
                cursor.toNextToken();
            }
            switch (tokenType) {
            case TokenType.INT_TEXT:
                result = cursor.getChars();
                break;
            case TokenType.INT_END:
                if (!attrExist) {
                    result = null;
                }
                break;
            }
        }
        finally {
            cursor.dispose();
        }
        return result;
    }

    public static void setMixedContentValue(TExternalParameter obj,
                                            String value) {
        XmlCursor cursor = obj.newCursor();
        try {
            while (cursor.currentTokenType().intValue() != TokenType.INT_END)
                cursor.toNextToken();
            cursor.insertChars(value);
        }
        finally {
            cursor.dispose();
        }
    }

    public static String removeNamespace(String obj) {
        String newStr = obj.replaceFirst("<.*variableAssignments.*>",
                                         "<variableAssignments>");
        newStr = newStr.replaceAll("req:", "");
        return newStr;
    }

    public static String removeXmlOuter(String str) {
        return str.replace("</variableAssignments>", "</xml-fragment>")
                .replace("variableAssignments",
                         "xml-fragment xmlns:req=\"http://www.tmax.com/tbhub/request\"")
//                .replace("xmlns=", "xmlns:req=")
                .replace("<v", "<req:v").replace("</v", "</req:v");

    }
}
