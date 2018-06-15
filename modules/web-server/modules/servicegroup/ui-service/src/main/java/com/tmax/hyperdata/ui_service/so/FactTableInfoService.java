package com.tmax.hyperdata.ui_service.so;

import com.tmax.hyperdata.ui_service.dao.FactTableInfoDAO;
import com.tmax.hyperdata.ui_service.dto.FactTableInfo;

import java.util.List;

/**
 * Created by hanul on 18. 6. 8.
 */
public class FactTableInfoService {
    public FactTableInfoService() {
    }

    public List<FactTableInfo> getAllFactTableList() throws Exception {
        List<FactTableInfo> factTableList = FactTableInfoDAO.getInstance().selectAll();
        return factTableList;
    }

    public List<FactTableInfo> findByName(String factTableName) throws Exception {
        return FactTableInfoDAO.getInstance().selectByName(factTableName);
    }

    public void insertFactTableInfo(FactTableInfo factTableInfo) throws Exception {
        FactTableInfoDAO.getInstance().insertFactTableInfo(factTableInfo);
    }

    public void deleteFactTableInfo(FactTableInfo factTableInfo) throws Exception {
        FactTableInfoDAO.getInstance().deleteFactTableInfo(factTableInfo);
    }

    public void updateFactTableInfo(FactTableInfo factTableInfo) throws Exception {
        FactTableInfoDAO.getInstance().modifyFactTableInfo(factTableInfo);
    }
}
