package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class AllOlapModelInfoGetExecutor extends ServiceExecutor {
    public AllOlapModelInfoGetExecutor() {
        this.serviceObject = new AllOlapModelInfoGet();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}