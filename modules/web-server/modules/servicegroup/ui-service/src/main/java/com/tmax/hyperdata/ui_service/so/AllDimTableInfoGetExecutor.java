package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class AllDimTableInfoGetExecutor extends ServiceExecutor {
    public AllDimTableInfoGetExecutor() {
        this.serviceObject = new AllDimTableInfoGet();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
