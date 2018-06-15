package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.OlapProjectInfoDAO;
import com.tmax.hyperdata.ui_service.dto.OlapProjectInfo;

import java.util.List;

public class OlapProjectInfoService {
    public OlapProjectInfoService() {
    }

    public List<OlapProjectInfo> getAllOlapProjectList() throws Exception {
        List<OlapProjectInfo> olapProjectList = OlapProjectInfoDAO.getInstance().selectAll();
        return olapProjectList;
    }

    public void insertOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        OlapProjectInfoDAO.getInstance().insertOlapProjectInfo(olapProjectInfo);
    }

    public void deleteOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        OlapProjectInfoDAO.getInstance().deleteOlapProjectInfo(olapProjectInfo);
    }

    public void updateOlapProjectInfo(OlapProjectInfo olapProjectInfo) throws Exception {
        OlapProjectInfoDAO.getInstance().modifyOlapProjectInfo(olapProjectInfo);
    }
}