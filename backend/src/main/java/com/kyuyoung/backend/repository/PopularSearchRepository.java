package com.kyuyoung.backend.repository;

import com.kyuyoung.backend.entity.PopularSearchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularSearchRepository extends JpaRepository<PopularSearchEntity, String> {

}
