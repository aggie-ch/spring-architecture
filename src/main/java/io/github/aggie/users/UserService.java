package io.github.aggie.users;

import io.github.aggie.common.PagedResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository usersRepository;

    public User add(User user) {
        return usersRepository.save(user);
    }

    public User getById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

    public PagedResult<User> getByLastName(String lastNameFragment, int pageNumber, int pageSize) {
        var userPage = usersRepository.findByLastNameContaining(lastNameFragment, PageRequest.of(pageNumber, pageSize));
        return new PagedResult<>(userPage.getContent(), pageNumber, userPage.getTotalPages());
    }
}
