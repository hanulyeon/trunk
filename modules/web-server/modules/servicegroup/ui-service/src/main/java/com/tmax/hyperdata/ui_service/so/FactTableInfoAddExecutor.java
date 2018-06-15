package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class FactTableInfoAddExecutor extends ServiceExecutor {
    public FactTableInfoAddExecutor() {
        this.serviceObject = new FactTableInfoAdd();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
