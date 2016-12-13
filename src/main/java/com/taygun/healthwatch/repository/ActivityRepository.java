package com.taygun.healthwatch.repository;

import com.taygun.healthwatch.domain.Activity;
import com.taygun.healthwatch.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    Optional<Activity> findOneByCode(int code);

    @Query("Select a from Activity a where a.description like %:desc%")
    List<Activity> ActivityContaining(@Param(value="desc") String desc);
}
