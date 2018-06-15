package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList;
import com.tmax.proobject.core.exception.ProObjectWebException;
import com.tmax.proobject.model.service.ServiceObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanul on 18. 6. 12.
 */
public class OlapCubeMeasureParamAdd implements ServiceObject {
    private OlapCubeMeasureParamService olapCubeMeasureParamService = new OlapCubeMeasureParamService();

    public OlapCubeMeasureParamAdd() {
    }

    public Object service(Object input) throws Throwable {
        try {
            List<OlapCubeMeasureParam> olapCubeMeasureParamList = new ArrayList();
            olapCubeMeasureParamList = (List<OlapCubeMeasureParam>) input;
            this.olapCubeMeasureParamService.insertOlapCubeMeasureParam(olapCubeMeasureParamList);
            return null;
        } catch (Exception var3) {
            throw new ProObjectWebException(500, "500", "HyperData Exception", var3.toString());
        }
    }
}
