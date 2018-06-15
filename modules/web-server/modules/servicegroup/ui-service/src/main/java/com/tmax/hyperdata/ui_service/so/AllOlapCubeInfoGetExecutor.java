package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class AllOlapCubeInfoGetExecutor extends ServiceExecutor {
    public AllOlapCubeInfoGetExecutor() {
        this.serviceObject = new AllOlapCubeInfoGet();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}