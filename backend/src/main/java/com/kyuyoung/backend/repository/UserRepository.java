package com.kyuyoung.backend.repository;

import com.kyuyoung.backend.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    public boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);
}
