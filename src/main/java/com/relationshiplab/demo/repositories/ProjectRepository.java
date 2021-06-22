package com.relationshiplab.demo.repositories;

import com.relationshiplab.demo.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
