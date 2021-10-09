package io.github.aggie.users;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source =  "emailAddress", target = "email")
    User toUser(UserTransferObject userTransferObject);

    @Mapping(source =  "email", target = "emailAddress")
    UserTransferObject toUserTransferObject(User user);
}
