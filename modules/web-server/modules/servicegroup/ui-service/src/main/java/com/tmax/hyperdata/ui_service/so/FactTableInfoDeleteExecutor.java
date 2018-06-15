package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class FactTableInfoDeleteExecutor extends ServiceExecutor {
    public FactTableInfoDeleteExecutor() {
        this.serviceObject = new FactTableInfoDelete();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
