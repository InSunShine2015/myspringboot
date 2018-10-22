package com.sun.dao.impl;


import com.sun.dao.ISmsAppInfoDao;
import com.sun.entity.TblSmsProjectInfo;
import com.sun.mapper.TblSmsProjectInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SmsAppInfoDao implements ISmsAppInfoDao {

    @Autowired
    private TblSmsProjectInfoMapper tblSmsProjectInfoMapper;

    @Override
    public List<TblSmsProjectInfo> queryAll() {
        return tblSmsProjectInfoMapper.selectList(null);
    }
}