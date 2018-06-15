package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class DimTableInfoModifyExecutor extends ServiceExecutor {
    public DimTableInfoModifyExecutor() {
        this.serviceObject = new DimTableInfoModify();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
