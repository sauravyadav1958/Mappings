package com.example.mappings.ManyToMany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepoM extends JpaRepository<CourseM, Long> {



}
