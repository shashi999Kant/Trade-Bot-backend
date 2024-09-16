package com.shashi.repository;

import com.shashi.model.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationCode,Long> {
    VerificationCode findByUserId(Long userId);
}
