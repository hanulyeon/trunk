package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;
import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.network.RequestContext;
import com.tmax.proobject.model.service.ServiceObject;

public class OlapModelInfoAdd implements ServiceObject {
    private OlapModelInfoService olapModelInfoService = new OlapModelInfoService();

    public OlapModelInfoAdd() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapModelInfo olapModelInfo = (OlapModelInfo)input;
            this.olapModelInfoService.insertOlapModelInfo(olapModelInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}