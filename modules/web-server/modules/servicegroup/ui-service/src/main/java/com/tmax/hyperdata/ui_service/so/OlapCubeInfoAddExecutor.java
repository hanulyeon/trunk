package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class OlapCubeInfoAddExecutor extends ServiceExecutor {
    public OlapCubeInfoAddExecutor() {
        this.serviceObject = new OlapCubeInfoAdd();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}