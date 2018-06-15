package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.DimTableInfoDAO;
import com.tmax.hyperdata.ui_service.dto.DimTableInfo;

import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class DimTableInfoService {
    public DimTableInfoService() {
    }

    public List<DimTableInfo> getAllDimTableList() throws Exception {
        List<DimTableInfo> dimTableList = DimTableInfoDAO.getInstance().selectAll();
        return dimTableList;
    }

    public List<DimTableInfo> findByName(String dimTableName) throws Exception {
        return DimTableInfoDAO.getInstance().selectByName(dimTableName);
    }

    public void insertDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        DimTableInfoDAO.getInstance().insertDimTableInfo(dimTableInfo);
    }

    public void deleteDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        DimTableInfoDAO.getInstance().deleteDimTableInfo(dimTableInfo);
    }

    public void updateDimTableInfo(DimTableInfo dimTableInfo) throws Exception {
        DimTableInfoDAO.getInstance().modifyDimTableInfo(dimTableInfo);
    }
}
