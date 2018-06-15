package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapCubeInfo;
import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class OlapCubeInfoAdd implements ServiceObject {
    private OlapCubeInfoService olapCubeInfoService = new OlapCubeInfoService();

    public OlapCubeInfoAdd() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapCubeInfo olapCubeInfo = (OlapCubeInfo)input;
            this.olapCubeInfoService.insertOlapCubeInfo(olapCubeInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}