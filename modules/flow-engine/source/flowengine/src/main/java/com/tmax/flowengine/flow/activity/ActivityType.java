package com.tmax.flowengine.flow.activity;

public enum ActivityType {
    OUTBOUND(1),
    LOGGING(2),
    BLOCK(3);
    
    
    public ActivityType fromInt(int type) {
        if(values().length >= type) {
            return values()[type + 1];
        }
        return null;
    }
    
    
    
    private int type;
    
    
    private ActivityType(int type) {
        this.type = type;
    }
    
    public int toInt() {
        return type;
    }
}
