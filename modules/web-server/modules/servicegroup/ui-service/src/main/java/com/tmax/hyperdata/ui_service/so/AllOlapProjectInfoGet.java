package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.OlapProjectInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

public class AllOlapProjectInfoGet implements ServiceObject {
    private OlapProjectInfoService olapProjectInfoService = new OlapProjectInfoService();

    public AllOlapProjectInfoGet() {
    }

    public Object service(Object input) throws Throwable {
        try {
            OlapProjectInfoList olapProjectInfoList = new OlapProjectInfoList();
            olapProjectInfoList.setOlapProjectInfoList(this.olapProjectInfoService.getAllOlapProjectList());
            return olapProjectInfoList;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
