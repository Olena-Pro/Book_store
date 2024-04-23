package mate.academy.bookstore.service;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import mate.academy.bookstore.dto.user.UserRegistrationRequestDto;
import mate.academy.bookstore.dto.user.UserResponseDto;
import mate.academy.bookstore.excepion.RegistrationException;
import mate.academy.bookstore.mapper.UserMapper;
import mate.academy.bookstore.model.Role;
import mate.academy.bookstore.model.User;
import mate.academy.bookstore.repository.roles.RoleRepository;
import mate.academy.bookstore.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.email()).isPresent()) {
            throw new RegistrationException("Un able to complete registration");
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(requestDto.password()));
        Role role = roleRepository.findByName(Role.RoleName.USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user.setRoles(Set.of(role));
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDto findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Can't find user by email"));
    }
}
