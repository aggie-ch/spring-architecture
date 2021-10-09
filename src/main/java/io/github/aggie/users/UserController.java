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
    private final UriBuilder uriBuilder = new UriBuilder();

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        var userId = userService.add(user).getId();
        var locationUri = uriBuilder.requestUriWithId(userId);
        return ResponseEntity.created(locationUri).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
}
