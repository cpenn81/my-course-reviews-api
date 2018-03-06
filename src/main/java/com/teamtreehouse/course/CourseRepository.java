package com.teamtreehouse.course;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;


public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

    @RestResource(rel = "title-contains", path="containsTitle")
    Page<Course> findByTitleContaining(@Param("title") String title, Pageable page);


    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Course entity);

   // @Override
   // @PreAuthorize("hasRole('ROLE_ADMIN')")
   // Course save(Course entity);
}
