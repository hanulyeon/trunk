package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapProjectInfoModifyExecutor extends ServiceExecutor {
    public OlapProjectInfoModifyExecutor() { this.serviceObject = new OlapProjectInfoModify(); }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}