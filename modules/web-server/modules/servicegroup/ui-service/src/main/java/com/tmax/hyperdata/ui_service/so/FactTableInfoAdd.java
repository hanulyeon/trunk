package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class FactTableInfoAdd implements ServiceObject {
    private FactTableInfoService factTableInfoService = new FactTableInfoService();

    public FactTableInfoAdd() {
    }

    public Object service(Object input) throws Throwable {
        try {
            FactTableInfo factTableInfo = (FactTableInfo)input;
            this.factTableInfoService.insertFactTableInfo(factTableInfo);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
