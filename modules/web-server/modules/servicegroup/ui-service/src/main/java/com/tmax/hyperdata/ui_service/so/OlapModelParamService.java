package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.FactTableInfoDAO;
import com.tmax.hyperdata.ui_service.dao.OlapModelParamDAO;
import com.tmax.hyperdata.ui_service.dto.FactTableInfo;
import com.tmax.hyperdata.ui_service.dto.OlapModelParam;

import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class OlapModelParamService {
    public OlapModelParamService() {
    }

    public List<OlapModelParam> findByName(String modelId) throws Exception {
        return OlapModelParamDAO.getInstance().selectByName(modelId);
    }

    public void insertOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        OlapModelParamDAO.getInstance().insertOlapModelParam(olapModelParam);
    }

    public void deleteOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        OlapModelParamDAO.getInstance().deleteOlapModelParam(olapModelParam);
    }

    public void updateOlapModelParam(OlapModelParam olapModelParam) throws Exception {
        OlapModelParamDAO.getInstance().modifyOlapModelParam(olapModelParam);
    }
}
