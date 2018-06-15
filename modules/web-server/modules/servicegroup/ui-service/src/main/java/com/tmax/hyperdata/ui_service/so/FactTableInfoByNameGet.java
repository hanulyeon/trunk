package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfoList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.engine.servicemanager.ServiceManager;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.network.ProObjectRequest;
import com.tmax.proobject.model.network.RequestContext;
import com.tmax.proobject.model.service.ServiceObject;

/**
 * Created by hanul on 18. 6. 12.
 */
public class FactTableInfoByNameGet implements ServiceObject {
    private static final ProObjectLogger logger = ServiceLogger.getLogger();
    private FactTableInfoService factTableInfoService;

    public FactTableInfoByNameGet() {
        factTableInfoService = new FactTableInfoService();
    }

    @Override
    public Object service(Object input) throws Throwable {
        try {
            FactTableInfoList factTableInfoList = new FactTableInfoList();
            RequestContext requestContext = ServiceManager.getCurrentRequestContext();
            ProObjectRequest requestMessage = (ProObjectRequest) requestContext.getRequest();

            String factTableName = null;
            String[] values = requestMessage.getQueryString("factTableName");
            if (values != null) {
                for (String value : values) {
                    factTableName = value;
                }
            }

            if (factTableName == null)
                factTableInfoList.setFactTableInfoList(factTableInfoService.getAllFactTableList());
            else
                factTableInfoList.setFactTableInfoList(factTableInfoService.findByName(factTableName));

            if (factTableInfoList != null) {
                return factTableInfoList;
            } else {
                throw new ProObjectWebException(500, "500", "HyperData Exception", "Unknown Error");
            }
        } catch (Exception e) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", e.toString());
        }
    }
}
