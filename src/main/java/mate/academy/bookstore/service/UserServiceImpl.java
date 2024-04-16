package mate.academy.bookstore.service;

import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.bookstore.dto.user.UserResponseDto;
import mate.academy.bookstore.excepion.RegistrationException;
import mate.academy.bookstore.mapper.UserMapper;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(requestDto.email())) {
            throw new RegistrationException("User with this email: "
                    + requestDto.email()
                    + " already exists");
        }
        User user = userMapper.toModel(requestDto);
        return userMapper.toDto(userRepository.save(user));
    }
}
