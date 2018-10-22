package com.sun.dao;

import com.sun.entity.TblSmsProjectInfo;

import java.util.List;

public interface ISmsAppInfoDao {

    List<TblSmsProjectInfo> queryAll();
}