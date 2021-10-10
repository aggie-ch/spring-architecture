package io.github.aggie.users;

import io.github.aggie.common.PagedResult;
import io.github.aggie.common.web.ExceptionTransferObject;
import io.github.aggie.common.web.PagedResultTransferObject;
import io.github.aggie.common.web.UriBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    public PagedResultTransferObject<UserTransferObject> getUsersByLastName(@RequestParam String lastNameFragment,
                                                                            @RequestParam(defaultValue = "0") int pageNumber,
                                                                            @RequestParam(defaultValue = "5") int pageSize) {
        PagedResult<User> users = userService.getByLastName(lastNameFragment, pageNumber, pageSize);
        return userMapper.toUserTransferObjectsPage(users);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionTransferObject> onUserNotFound(UserNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionTransferObject("User not found"));
    }
}
