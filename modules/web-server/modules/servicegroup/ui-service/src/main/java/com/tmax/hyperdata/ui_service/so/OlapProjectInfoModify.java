package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class OlapProjectInfoModify implements ServiceObject {
    private OlapProjectInfoService olapProjectInfoService = new OlapProjectInfoService();

    public OlapProjectInfoModify() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapProjectInfo olapProjectInfo = (OlapProjectInfo)input;
            this.olapProjectInfoService.updateOlapProjectInfo(olapProjectInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}