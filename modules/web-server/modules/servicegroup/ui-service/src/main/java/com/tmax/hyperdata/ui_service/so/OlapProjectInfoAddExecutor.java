package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapProjectInfoAddExecutor extends ServiceExecutor {
    public OlapProjectInfoAddExecutor() {
        this.serviceObject = new OlapProjectInfoAdd();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}