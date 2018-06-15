package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * Created by hanul on 18. 6. 12.
 */
public class OlapCubeMeasureParamByIdGetExecutor extends ServiceExecutor {
    public OlapCubeMeasureParamByIdGetExecutor() {
        this.serviceObject = new OlapCubeMeasureParamByIdGet();
    }

    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return this.serviceObject.service(serviceInput);
    }
}
