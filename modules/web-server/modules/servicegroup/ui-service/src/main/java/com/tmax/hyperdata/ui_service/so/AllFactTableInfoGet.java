package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class AllFactTableInfoGet implements ServiceObject {
    private FactTableInfoService factTableInfoService = new FactTableInfoService();

    public AllFactTableInfoGet() {
    }

    public Object service(Object input) throws Throwable {
        try {
            FactTableInfoList factTableInfoList = new FactTableInfoList();
            factTableInfoList.setFactTableInfoList(this.factTableInfoService.getAllFactTableList());
            return factTableInfoList;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
