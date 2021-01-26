package com.nathan.learn.spring.dao;

import com.nathan.learn.spring.entity.JobEntity;
import com.nathan.learn.spring.entity.JobEntityState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Serializable> {
    List<JobEntity> findByApplicationIdNotNullAndStateIsIn(List<JobEntityState> states);
}
