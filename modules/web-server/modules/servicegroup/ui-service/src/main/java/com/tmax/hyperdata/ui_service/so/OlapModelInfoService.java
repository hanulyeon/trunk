package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.OlapModelInfoDAO;
import com.tmax.hyperdata.ui_service.dto.OlapModelInfo;

import java.util.List;

public class OlapModelInfoService {
    public OlapModelInfoService() {
    }

    public List<OlapModelInfo> getAllOlapModelList() throws Exception {
        List<OlapModelInfo> olapModelList = OlapModelInfoDAO.getInstance().selectAll();
        return olapModelList;
    }

    public void insertOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        OlapModelInfoDAO.getInstance().insertOlapModelInfo(olapModelInfo);
    }

    public void deleteOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        OlapModelInfoDAO.getInstance().deleteOlapModelInfo(olapModelInfo);
    }

    public void updateOlapModelInfo(OlapModelInfo olapModelInfo) throws Exception {
        OlapModelInfoDAO.getInstance().modifyOlapModelInfo(olapModelInfo);
    }
}