package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class OlapCubeMeasureParamAddGetExecutor extends ServiceExecutor {
    public OlapCubeMeasureParamAddGetExecutor() {
        this.serviceObject = new OlapCubeMeasureParamAdd();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
