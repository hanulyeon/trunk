package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class AllOlapProjectInfoGetExecutor extends ServiceExecutor {
    public AllOlapProjectInfoGetExecutor() {
        this.serviceObject = new AllOlapProjectInfoGet();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}