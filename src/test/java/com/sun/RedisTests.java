package com.sun;

import com.sun.entity.TblSmsProjectInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> reTempleate;
    @Test
    public void contextLoads() {
//		redisTemplate.opsForValue().set("test", "this my test Value");
//		Map<String,Object> map = new HashMap<>();
//		map.put("aa", "bb");
//		map.put("bb", 12);
//		map.put("cc", new Date());
//		redisTemplate.opsForValue().set("test", JSON.toJSONString(map));

        TblSmsProjectInfo info = new TblSmsProjectInfo();
        info.setAppId("110");
        info.setProjectName("测试应用名称1");
        info.setStatus(true);
        info.setLimitCount(3);
        info.setValidMinutes(30);
        info.setCreateTime(new Date());
        info.setUpdateTime(new Date());
        reTempleate.opsForValue().set("test-info", info);

        System.out.println(reTempleate.opsForValue().get("test-info"));
        TblSmsProjectInfo info1 = (TblSmsProjectInfo)reTempleate.opsForValue().get("test-info");
        System.out.println(info1.getProjectName());


        System.out.println("---------------------------");
//		redisTemplate.convertAndSend("app-update", "2018-09-19");
//		redisTemplate.convertAndSend("module-update", "2018-09-20");
        System.out.println("---------------------------");



    }

}