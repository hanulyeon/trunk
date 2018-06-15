package com.tmax.flowengine.flow.activity.outbound;

import com.tmax.proobject.model.event.Event;

/**
 * @author Tmax
 * @since  2018. 2. 28.
 */
public class AdapterResponseEvent extends Event {
    private String      message;
    private Throwable   exception;
    
    
    @Override
    public int getType() {
        return 400;
    }
    
    public boolean hasException() {
        return getException() != null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}
