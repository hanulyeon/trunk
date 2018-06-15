package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.DimTableInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class AllDimTableInfoGet implements ServiceObject {
    private DimTableInfoService dimTableInfoService = new DimTableInfoService();

    public AllDimTableInfoGet() {
    }

    public Object service(Object input) throws Throwable {
        try {
            DimTableInfoList dimTableInfoList = new DimTableInfoList();
            dimTableInfoList.setDimTableInfoList(this.dimTableInfoService.getAllDimTableList());
            return dimTableInfoList;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
