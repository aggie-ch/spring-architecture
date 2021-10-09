package io.github.aggie.users;

import io.github.aggie.common.UriBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final UriBuilder uriBuilder = new UriBuilder();

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody UserTransferObject userTransferObject) {
        User user = userMapper.toUser(userTransferObject);
        var userId = userService.add(user).getId();
        var locationUri = uriBuilder.requestUriWithId(userId);
        return ResponseEntity.created(locationUri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<UserTransferObject> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        UserTransferObject userTransferObject = userMapper.toUserTransferObject(user);
        return ResponseEntity.ok(userTransferObject);
    }
}
