package com.sun.config;

import com.alibaba.fastjson.JSON;
import com.sun.entity.TblSmsProjectInfo;
import com.sun.mapper.TblSmsProjectInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SmsApp {
    private static final Logger log = LoggerFactory.getLogger(SmsApp.class);
    private ConcurrentHashMap<String, TblSmsProjectInfo> projectsMap = new ConcurrentHashMap<>();
    @Autowired
    private TblSmsProjectInfoMapper smsProjectInfoMapper;

    public void loadDataFromDb() {
        log.info("load app datas from db ...");
        List<TblSmsProjectInfo> projects = smsProjectInfoMapper.selectList(null);
        for(TblSmsProjectInfo project:projects){
            if(project.getStatus()){
                projectsMap.put(project.getAppId(),project);
            }
        }
        log.info(JSON.toJSONString(projectsMap));
        log.info("load app datas from db end");
    }

    public TblSmsProjectInfo getProjectByAppId(String appId){
        return projectsMap.get(appId);
    }

    public boolean haveAppId(String appId){
        return projectsMap.containsKey(appId);
    }

    public Map<String, TblSmsProjectInfo> getProjectsMap() {
        return projectsMap;
    }

    public void setSmsAppInfo(TblSmsProjectInfo info){
         String key = info.getAppId();
         log.info("to handle app info : {}",JSON.toJSONString(info));
         if(!projectsMap.containsKey(key) && info.getStatus()){
             log.info("add new smsapp info to sys {}" ,key);
             projectsMap.put(key,info);
         }else if(projectsMap.containsKey(key) && !info.equals(projectsMap.get(key))){
             if(info.getStatus()){
                 log.info("reset smsapp info to sys {}", key);
                 projectsMap.put(key,info);
             } else{
                 log.info("delete smsapp info to sys {}" ,key);
                 projectsMap.remove(key);
             }
         }
    }
}