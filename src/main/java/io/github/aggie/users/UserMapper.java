package io.github.aggie.users;

import io.github.aggie.common.PagedResult;
import io.github.aggie.common.web.PagedResultTransferObject;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.*;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source =  "emailAddress", target = "email")
    User toUser(UserTransferObject userTransferObject);

    @Mapping(source =  "email", target = "emailAddress")
    UserTransferObject toUserTransferObject(User user);

    @IterableMapping(elementTargetType = UserTransferObject.class)
    List<UserTransferObject> toUserTransferObjects(List<User> users);

    PagedResultTransferObject<UserTransferObject> toUserTransferObjectsPage(PagedResult<User> usersPage);
}
