/**
 * Tibero, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.error;
import com.m.msl.logger.MLogger;

/**
 * @author Hongsu Ryu (hongsu_ryu@tmax.co.kr) 2016. 2. 12.
 * @version $Id: TbHdException.java 11 2017-12-07 03:24:29Z taebo $
 */

/**
 * HyperData 의 예외 처리를 위한 클래스
 */
public class TbHdException extends Exception {
    
    private int errCode = 0;
    private String errMessage = null;

    /**
     * HyperData용 exception 생성.
     *
     * @param code
     *            {@link TbHdError}의 error 중 하나
     */
    public TbHdException(int code) {
        super(TbHdError.getMsg(code));
        errCode = code;
    }
    
    public TbHdException(int code, String msg) {
        this(code);
        errCode = code;
        errMessage = msg;
    }
    
    /**
     * @return the errorCode
     */
    public int getCode() {
        return errCode;
    }

    public String getErrorCode() {
        return TbHdError.ERROR_STR_PREFIX + String.format("%05d", getCode());
    }

    @Override
    public String getMessage() {
        return errMessage != null ? TbHdError.getMsg(errCode) + "\n" +
                errMessage : TbHdError.getMsg(errCode);
    }

    @Override
    public String toString() {
        return getMessage();
    }

//    /**
//     * HyperData용 exception 생성.
//     *
//     * @param code
//     *            {@link TbHdError}의 error 중 하나
//     * @param parent
//     *            이전에 발생한 {@link TbHyperDataException2}
//     */
//    public TbHyperDataException2(int code, TbHyperDataException2 parent) {
//        hyperDataError = code;
//        parentException = parent;
//    }
//
//
//    /**
//     * HyperData용 exception 생성.
//     *
//     * @param code
//     *            {@link TbHdError}의 error 중 하나
//     * @param msg
//     *            에러에 추가할 자세한 메세지
//     * @param parent
//     *            이전에 발생한 {@link TbHyperDataException2}
//     */
//    public TbHyperDataException2(int code, String msg,
//                              TbHyperDataException2 parent) {
//        hyperDataError = code;
//        additionalMsg = msg;
//        parentException = parent;
//        
//    }

//    /**
//     * @return the parentException
//     */
//    public TbHyperDataException2 getParent() {
//        return parentException;
//    }

//

}