package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapCubeInfoModifyExecutor extends ServiceExecutor {
    public OlapCubeInfoModifyExecutor() {
        this.serviceObject = new OlapCubeInfoModify();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}