package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class FactTableInfoModify implements ServiceObject {
    private FactTableInfoService factTableInfoService = new FactTableInfoService();

    public FactTableInfoModify() {
    }

    public Object service(Object input) throws Throwable {
        try {
            FactTableInfo factTableInfo = (FactTableInfo)input;
            this.factTableInfoService.updateFactTableInfo(factTableInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
