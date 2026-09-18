package com.sankalp.backend.repository;

import com.sankalp.backend.entity.UsernameChangeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernameChangeRequestRepository
        extends JpaRepository<UsernameChangeRequest, Long> {

}