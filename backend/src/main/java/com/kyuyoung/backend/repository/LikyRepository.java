package com.kyuyoung.backend.repository;

import com.kyuyoung.backend.entity.LikyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, Integer> {

}
