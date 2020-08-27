package com.zhaogang.demo.repository;

import com.zhaogang.demo.entity.SimsStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author baiyang
 * @date 2020/8/11
 */
public interface SimsStudentRepository extends JpaRepository<SimsStudent, String>, CrudRepository<SimsStudent, String> {

    @Override
    <S extends SimsStudent> S save(S s);
}
