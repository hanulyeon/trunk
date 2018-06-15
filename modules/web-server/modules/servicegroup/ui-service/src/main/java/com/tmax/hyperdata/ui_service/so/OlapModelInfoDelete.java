package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class OlapModelInfoDelete implements ServiceObject {
    private OlapModelInfoService olapModelInfoService = new OlapModelInfoService();

    public OlapModelInfoDelete() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapModelInfo olapModelInfo = (OlapModelInfo)input;
            this.olapModelInfoService.deleteOlapModelInfo(olapModelInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}