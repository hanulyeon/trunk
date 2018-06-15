package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapModelInfoAddExecutor extends ServiceExecutor {
    public OlapModelInfoAddExecutor() {
        this.serviceObject = new OlapModelInfoAdd();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}