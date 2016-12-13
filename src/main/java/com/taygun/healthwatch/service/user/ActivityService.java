package com.taygun.healthwatch.service.user;

import com.taygun.healthwatch.domain.Activity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ActivityService {

    Optional<Activity> getActivityById(long id);

    Optional<Activity> getActivityByCode(int code);

    Collection<Activity> getAllActivitys();

    List<Activity> getActivityContaining(String desc);
}
