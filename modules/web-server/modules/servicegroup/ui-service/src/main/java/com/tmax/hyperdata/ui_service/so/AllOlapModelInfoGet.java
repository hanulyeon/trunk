package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapModelInfoList;
import com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class AllOlapModelInfoGet implements ServiceObject {
    private OlapModelInfoService olapModelInfoService = new OlapModelInfoService();

    public AllOlapModelInfoGet() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapModelInfoList olapModelInfoList = new OlapModelInfoList();
            olapModelInfoList.setOlapModelInfoList(this.olapModelInfoService.getAllOlapModelList());
            return olapModelInfoList;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
