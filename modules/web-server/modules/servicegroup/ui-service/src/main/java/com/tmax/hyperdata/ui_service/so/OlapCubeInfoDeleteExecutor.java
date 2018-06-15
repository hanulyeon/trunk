package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapCubeInfoDeleteExecutor extends ServiceExecutor {
    public OlapCubeInfoDeleteExecutor() {
        this.serviceObject = new OlapCubeInfoDelete();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}