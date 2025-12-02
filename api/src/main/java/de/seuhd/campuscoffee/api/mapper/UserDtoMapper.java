package de.seuhd.campuscoffee.api.mapper;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

import de.seuhd.campuscoffee.api.dtos.UserDto;
import de.seuhd.campuscoffee.domain.model.User;


@Mapper(componentModel = "spring")
@ConditionalOnMissingBean // prevent IntelliJ warning about duplicate beans
public interface UserDtoMapper {
    //TODO: Implement user DTO mapper DONE

    UserDto fromDomain(User source);
    User toDomain(UserDto source);
}
