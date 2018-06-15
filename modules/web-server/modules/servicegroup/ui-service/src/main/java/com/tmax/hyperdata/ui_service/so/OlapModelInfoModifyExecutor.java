package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapModelInfoModifyExecutor extends ServiceExecutor {
    public OlapModelInfoModifyExecutor() {
        this.serviceObject = new OlapModelInfoModify();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}