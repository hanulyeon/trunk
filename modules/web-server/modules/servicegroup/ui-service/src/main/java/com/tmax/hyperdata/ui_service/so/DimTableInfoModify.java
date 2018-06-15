package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.DimTableInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class DimTableInfoModify implements ServiceObject {
    private DimTableInfoService dimTableInfoService = new DimTableInfoService();

    public DimTableInfoModify() {
    }

    public Object service(Object input) throws Throwable {
        try {
            DimTableInfo dimTableInfo = (DimTableInfo)input;
            this.dimTableInfoService.updateDimTableInfo(dimTableInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
