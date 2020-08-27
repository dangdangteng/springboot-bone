package com.zhaogang.demo.controller;

import com.zhaogang.demo.entity.SimsStudent;
import com.zhaogang.demo.service.SimsStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baiyang
 * @date 2020/8/10
 */
@Api(value = "并发测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SimsStudentService simsStudentService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }

    @ApiOperation("保存数据 datetime 类型时间")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "simsStudent", value = "simsStudent", dataTypeClass = SimsStudent.class)}
    )
    @PostMapping("/saveSimsStudent")
    public void saveSimsStudent(@RequestBody SimsStudent simsStudent) {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date.toString());
        simsStudent.setCreatedTime(date);
        simsStudent.setBirth(date);
        simsStudentService.save(simsStudent);
    }

    @ApiOperation("查看数据")
    @PostMapping("/selectAll")
    public List<SimsStudent> selectAll() {
        List<SimsStudent> all = simsStudentService.findAll();
        return all;
    }
}
