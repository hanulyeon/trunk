package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.DimTableInfoList;
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
public class DimTableInfoByNameGet implements ServiceObject {
    private static final ProObjectLogger logger = ServiceLogger.getLogger();
    private DimTableInfoService dimTableInfoService;

    public DimTableInfoByNameGet() {
        dimTableInfoService = new DimTableInfoService();
    }

    @Override
    public Object service(Object input) throws Throwable {
        try {
            DimTableInfoList dimTableInfoList = new DimTableInfoList();
            RequestContext requestContext = ServiceManager.getCurrentRequestContext();
            ProObjectRequest requestMessage = (ProObjectRequest) requestContext.getRequest();

            String dimTableName = null;
            String[] values = requestMessage.getQueryString("dimTableName");
            if (values != null) {
                for (String value : values) {
                    dimTableName = value;
                }
            }

            if (dimTableName == null)
                dimTableInfoList.setDimTableInfoList(dimTableInfoService.getAllDimTableList());
            else
                dimTableInfoList.setDimTableInfoList(dimTableInfoService.findByName(dimTableName));

            if (dimTableInfoList != null) {
                return dimTableInfoList;
            } else {
                throw new ProObjectWebException(500, "500", "HyperData Exception", "Unknown Error");
            }
        } catch (Exception e) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", e.toString());
        }
    }
}
