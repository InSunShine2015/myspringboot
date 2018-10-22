package com.sun.controller;


import com.baomidou.mybatisplus.extension.api.ApiController;
import com.sun.config.UpdateConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sunxg
 * @since 2018-10-22
 */
@RestController
@RequestMapping("/project")
public class TblSmsProjectInfoController extends ApiController {
      @Autowired
    private UpdateConfig updateConfig;
      @GetMapping("/info")
      public String info(){
        return "name --> "+updateConfig.getSmsApp().getProjectByAppId("110").getProjectName();
      }
}
