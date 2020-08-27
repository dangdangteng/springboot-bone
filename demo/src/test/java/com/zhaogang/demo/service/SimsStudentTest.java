package com.zhaogang.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhaogang.demo.entity.SimsStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author baiyang
 * @date 2020/8/11
 */
@SpringBootTest
public class SimsStudentTest {

    @Autowired
    private SimsStudentService simsStudentService;

    private ObjectMapper objectMapper;

    @Test
    void testSave() throws Exception{
        SimsStudent simsStudent = new SimsStudent();
        simsStudent.setCollegeId("Ceshi");
        SimsStudent save = simsStudentService.save(simsStudent);
        System.out.println(save.toString());
    }
}
