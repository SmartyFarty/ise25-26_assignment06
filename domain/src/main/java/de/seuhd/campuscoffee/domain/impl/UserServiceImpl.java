package de.seuhd.campuscoffee.domain.impl;


import de.seuhd.campuscoffee.domain.model.User;
import de.seuhd.campuscoffee.domain.ports.UserDataService;
import de.seuhd.campuscoffee.domain.ports.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    // TODO: Implement user service DONE
    private final UserDataService userDataService;

    @Override
    public void clear() {
        log.warn("Clearing all User data");
        userDataService.clear();
    }

    @Override
    public @NonNull List<User> getAll()   {
    log.debug("Retrieving all Users");
    return userDataService.getAll();
    }

    @Override
    public @NonNull User getById(@NonNull Long id) {
        log.debug("Retrieving Users with ID: {}", id);
        return userDataService.getById(id);
    }

    @Override
    public @NonNull User getByLoginName(@NonNull String loginName) {
        log.debug("Retrieving User with name: {}", loginName);
        return userDataService.getByLoginName(loginName);
    }

    private @NonNull User performUpsert(@NonNull User user) {
        return userDataService.upsert(user);
    }


    @Override
    public @NonNull User upsert(@NonNull User user) {
        if (user.id() == null) {
            log.info("Creating new User: {}", user.loginName());
        } else {
            log.info("Updating User with ID: {}", user.id());
            Objects.requireNonNull(user.id());
            userDataService.getById(user.id());
        }
        return performUpsert(user);
    }


    @Override
    public void delete(@NonNull Long id) {
        log.info("Trying to delete POS with ID: {}", id);
        userDataService.delete(id);
        log.info("Deleted POS with ID: {}", id);
    }
}
