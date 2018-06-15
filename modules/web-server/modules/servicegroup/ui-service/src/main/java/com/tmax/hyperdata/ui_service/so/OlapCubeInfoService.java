package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.OlapCubeInfoDAO;
import com.tmax.hyperdata.ui_service.dto.OlapCubeInfo;

import java.util.List;

public class OlapCubeInfoService {
    public OlapCubeInfoService() {
    }

    public List<OlapCubeInfo> getAllOlapCubeList() throws Exception {
        List<OlapCubeInfo> olapCubeList = OlapCubeInfoDAO.getInstance().selectAll();
        return olapCubeList;
    }

    public void insertOlapCubeInfo(OlapCubeInfo olapCubeLInfo) throws Exception {
        OlapCubeInfoDAO.getInstance().insertOlapCubeInfo(olapCubeLInfo);
    }

    public void deleteOlapCubeInfo(OlapCubeInfo olapCubeLInfo) throws Exception {
        OlapCubeInfoDAO.getInstance().deleteOlapCubeInfo(olapCubeLInfo);
    }

    public void updateOlapCubeInfo(OlapCubeInfo olapCubeLInfo) throws Exception {
        OlapCubeInfoDAO.getInstance().modifyOlapCubeInfo(olapCubeLInfo);
    }
}