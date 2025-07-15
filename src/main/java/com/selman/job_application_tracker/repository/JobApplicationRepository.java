package com.selman.job_application_tracker.repository;

import com.selman.job_application_tracker.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface JobApplicationRepository
        extends JpaRepository<JobApplication, Long> {
}
