/**
 * TmaxData, Co. Copyright(C) 2001-, All rights reserved.
 */
package com.tmax.hyperdata.ui_service.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

/**
 * @author cbo (byeongok_choi@tmax.com) 2017. 09. 1.
 * @version $Id$
 */

/**
 * Instance List�� �������� Create Api�� Executor.
 */
public class ModelCreateExecutor extends ServiceExecutor {

    public ModelCreateExecutor() {
        serviceObject = new ModelCreate();
    }

    @SuppressWarnings("unchecked")
    public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
        return serviceObject.service(serviceInput);
    }

    public String getRendezvousMethodName(String service) {
        return null;
    }
}
