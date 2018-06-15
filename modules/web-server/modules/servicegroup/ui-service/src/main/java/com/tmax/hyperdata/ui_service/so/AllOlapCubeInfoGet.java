package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapCubeInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class AllOlapCubeInfoGet implements ServiceObject {
    private OlapCubeInfoService olapCubeInfoService = new OlapCubeInfoService();

    public AllOlapCubeInfoGet() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapCubeInfoList olapCubeInfoList = new OlapCubeInfoList();
            olapCubeInfoList.setOlapCubeInfoList(this.olapCubeInfoService.getAllOlapCubeList());
            return olapCubeInfoList;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
