package com.foot.api.spring_foot_api.repository;

import com.foot.api.spring_foot_api.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    List<Coach> findByEquipeId(Long equipeId);

}

