package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.OlapCubeMeasureParamDAO;
import com.tmax.hyperdata.ui_service.dao.OlapModelParamDAO;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParam;
import com.tmax.hyperdata.ui_service.dto.OlapCubeMeasureParamList;
import com.tmax.hyperdata.ui_service.dto.OlapModelParam;

import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class OlapCubeMeasureParamService {
    public OlapCubeMeasureParamService() {
    }

    public List<OlapCubeMeasureParam> findById(int cubeId) throws Exception {
        return OlapCubeMeasureParamDAO.getInstance().selectById(cubeId);
    }

    public void insertOlapCubeMeasureParam(List<OlapCubeMeasureParam> olapCubeMeasureParamList) throws Exception {
        OlapCubeMeasureParamDAO.getInstance().insertOlapCubeMeasureParam(olapCubeMeasureParamList);
    }

//    public void deleteOlapCubeMeasureParam(OlapCubeMeasureParam olapCubeMeasureParam) throws Exception {
//        OlapCubeMeasureParamDAO.getInstance().deleteOlapCubeMeasureParam(olapCubeMeasureParam);
//    }
//
//    public void updateOlapCubeMeasureParam(OlapCubeMeasureParam olapCubeMeasureParam) throws Exception {
//        OlapCubeMeasureParamDAO.getInstance().modifyOlapCubeMeasureParam(olapCubeMeasureParam);
//    }
}
