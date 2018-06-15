package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapModelInfoDeleteExecutor extends ServiceExecutor {
    public OlapModelInfoDeleteExecutor() {
        this.serviceObject = new OlapModelInfoDelete();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}