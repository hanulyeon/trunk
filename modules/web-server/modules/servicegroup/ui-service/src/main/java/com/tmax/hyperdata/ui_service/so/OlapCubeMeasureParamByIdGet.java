package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfoList;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList;
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
public class OlapCubeMeasureParamByIdGet implements ServiceObject {
    private static final ProObjectLogger logger = ServiceLogger.getLogger();
    private OlapCubeMeasureParamService olapCubeMeasureParamService;

    public OlapCubeMeasureParamByIdGet() {
        olapCubeMeasureParamService = new OlapCubeMeasureParamService();
    }

    @Override
    public Object service(Object input) throws Throwable {
        try {
            OlapCubeMeasureParamList olapCubeMeasureParamList = new OlapCubeMeasureParamList();
            RequestContext requestContext = ServiceManager.getCurrentRequestContext();
            ProObjectRequest requestMessage = (ProObjectRequest) requestContext.getRequest();

            String cubeId = null;
            String[] values = requestMessage.getQueryString("cubeId");
            if (values != null) {
                for (String value : values) {
                    cubeId = value;
                }
            }

            if (cubeId == null)
//                olapCubeMeasureParamList.setOlapCubeMeasureParamList(olapCubeMeasureParamService.getAllFactTableList());
                throw new ProObjectWebException(500, "500", "HyperData Exception", "Unknown Error");
            else
                olapCubeMeasureParamList.setOlapCubeMeasureParamList(olapCubeMeasureParamService.findById(Integer.parseInt(cubeId)));

            if (olapCubeMeasureParamList != null) {
                return olapCubeMeasureParamList;
            } else {
                throw new ProObjectWebException(500, "500", "HyperData Exception", "Unknown Error");
            }
        } catch (Exception e) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", e.toString());
        }
    }
}
