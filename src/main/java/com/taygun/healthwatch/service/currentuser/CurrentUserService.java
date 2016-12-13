package com.taygun.healthwatch.service.currentuser;

import com.taygun.healthwatch.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
