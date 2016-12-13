package com.taygun.healthwatch.service.user;

import com.taygun.healthwatch.domain.Activity;
import com.taygun.healthwatch.domain.User;
import com.taygun.healthwatch.domain.UserCreateForm;
import com.taygun.healthwatch.repository.ActivityRepository;
import com.taygun.healthwatch.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityServiceImpl.class);
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository= activityRepository;
    }

    @Override
    public Optional<Activity> getActivityById(long id) {
        LOGGER.debug("Getting user={}", id);
        return Optional.ofNullable(activityRepository.findOne(id));
    }

    @Override
    public Optional<Activity> getActivityByCode(int code) {
        return activityRepository.findOneByCode(code);
    }

    @Override
    public Collection<Activity> getAllActivitys() {
        LOGGER.debug("Getting all users");
        return activityRepository.findAll(new Sort("code"));
    }

    @Override
    public List<Activity> getActivityContaining(String desc) {
        return activityRepository.ActivityContaining(desc);
    }

}
