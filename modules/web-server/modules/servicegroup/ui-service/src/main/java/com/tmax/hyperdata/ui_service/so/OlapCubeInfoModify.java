package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapCubeInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class OlapCubeInfoModify implements ServiceObject {
    private OlapCubeInfoService olapCubeInfoService = new OlapCubeInfoService();

    public OlapCubeInfoModify() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapCubeInfo olapCubeInfo = (OlapCubeInfo)input;
            this.olapCubeInfoService.updateOlapCubeInfo(olapCubeInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}