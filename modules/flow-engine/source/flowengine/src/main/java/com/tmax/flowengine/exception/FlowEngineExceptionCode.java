package com.tmax.flowengine.exception;

import com.tmax.proobject.core.constant.ExceptionCode;

public enum FlowEngineExceptionCode implements ExceptionCode {
    /**
     * ADT-1000 : 요청하려는 Adapter 와의 커넥션이 없는 경우 반환되는 코드.
     */
    ADAPTER_NOT_CONNECTED(FlowEngineModuleCode.ADAPTER, 1000, "AdapterNotConnected");
    
    
    
    

    private String  codeName    = null;
    private String  code        = null;
    
    
    private FlowEngineExceptionCode(FlowEngineModuleCode moduleCode, int codeNumber, String codeName) {
        String codeNumberString = Integer.toString(codeNumber);
        int remainingLength = 4 - codeNumberString.length();
        for(int i=0; i<remainingLength; i++) {
            codeNumberString = "0" + codeNumberString;
        }
        this.codeName   = codeName;
        this.code       = moduleCode.getAbbreviation() + "-" + codeNumberString;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    @Override
    public String getCodeName() {
        return codeName;
    }
}
