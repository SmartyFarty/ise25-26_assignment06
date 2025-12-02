package de.seuhd.campuscoffee.domain.ports;

import de.seuhd.campuscoffee.domain.model.User;
import org.jspecify.annotations.NonNull;

import java.util.List;

public interface UserService {
    //TODO: Define user service interface DONE


    void clear(); //Delete all users

    @NonNull List<User> getAll(); //List all users

    @NonNull User getById(@NonNull Long id); //Get user based on ID

    @NonNull User getByLoginName(@NonNull String loginName); //Get user based on loginName

    @NonNull User upsert(@NonNull User user); //Insert new user

    void delete(@NonNull Long id); //Delete user based on ID

}
