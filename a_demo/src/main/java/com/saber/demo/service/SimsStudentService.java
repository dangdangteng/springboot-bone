package com.saber.demo.service;

import com.saber.demo.repository.SimsStudentRepository;
import com.saber.demo.entity.SimsStudent;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author baiyang
 * @date 2020/8/11
 */
@Service
public class SimsStudentService {
    @Autowired
    private SimsStudentRepository simsStudentRepository;

    public SimsStudent save(SimsStudent simsStudent){
        SimsStudent save = simsStudentRepository.save(simsStudent);
        return save;
    }

    public List<SimsStudent> findAll(){
        List<SimsStudent> all = simsStudentRepository.findAll();
        return all;
    }
}
