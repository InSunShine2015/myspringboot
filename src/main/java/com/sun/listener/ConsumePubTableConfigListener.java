package com.sun.listener;


import com.sun.common.SysConstants;
import com.sun.config.UpdateConfig;
import com.sun.dao.ISmsAppInfoDao;
import com.sun.entity.TblSmsProjectInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;


public class ConsumePubTableConfigListener implements MessageListener {
    private static final Logger log = LoggerFactory.getLogger(ConsumePubTableConfigListener.class);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private UpdateConfig appConfig;
    @Autowired
    private ISmsAppInfoDao iSmsAppInfoDao;
//    @Autowired
//    private ISmsModuleInfoDao iSmsModuleInfoDao;

	@Override
	public void onMessage(Message message, byte[] pattern) {
        log.info("receive message ......");
		handleMessage(message);

	}

	public void handleMessage(Message message) {
		Object channel = stringRedisTemplate.getValueSerializer().deserialize(message.getChannel());
		Object value = stringRedisTemplate.getValueSerializer().deserialize(message.getBody());
		String channelStr =  String.valueOf(channel);
		String messageStr =  String.valueOf(value);
        log.info("message channel from :"+ channelStr + ":::::::: consumer message: "+ messageStr);
        if(SysConstants.TABLE_CONFIG_APP_UPDATE.equals(channelStr)){
            log.info("reload appConfig from table....");
            List<TblSmsProjectInfo> infos = iSmsAppInfoDao.queryAll();
            for(TblSmsProjectInfo info:infos){
                appConfig.getSmsApp().setSmsAppInfo(info);
            }
        }
//        if(LejaneConstants.TABLE_CONFIG_MODULE_UPDATE.equals(channelStr)){
//            log.info("reload moduleConfig from table....");
//            List<SmsModuleInfo> infos = iSmsModuleInfoDao.queryAll();
//            for(SmsModuleInfo info:infos){
//                appConfig.getSmsModule().setSmsModuleInfo(info);
//            }
//        }
	}

}
