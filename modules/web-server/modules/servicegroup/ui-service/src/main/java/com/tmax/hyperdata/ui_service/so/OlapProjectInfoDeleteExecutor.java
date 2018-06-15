package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapProjectInfoDeleteExecutor extends ServiceExecutor {
    public OlapProjectInfoDeleteExecutor() {
        this.serviceObject = new OlapProjectInfoDelete();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}