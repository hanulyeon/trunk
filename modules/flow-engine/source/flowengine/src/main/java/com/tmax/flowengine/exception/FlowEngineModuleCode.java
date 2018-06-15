package com.tmax.flowengine.exception;

public enum FlowEngineModuleCode {
    ADAPTER("ADT");
    
    
    
    
    private String abbreviation;
    
    
    private FlowEngineModuleCode(String abbreviation) {
        this.abbreviation = abbreviation;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
}
