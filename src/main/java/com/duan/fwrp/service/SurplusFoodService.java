package com.duan.fwrp.service;

import com.duan.fwrp.dao.SurplusFoodDAO;
import com.duan.fwrp.entity.SurplusFood;

import java.sql.SQLException;
import java.util.List;

public class SurplusFoodService {
    private SurplusFoodDAO surplusFoodDAO;

    public SurplusFoodService() throws SQLException {
        surplusFoodDAO = new SurplusFoodDAO();
    }

    public List<SurplusFood> getAllSurplusFoods() throws SQLException {
        return surplusFoodDAO.getAllSurplusFoods();
    }
}


