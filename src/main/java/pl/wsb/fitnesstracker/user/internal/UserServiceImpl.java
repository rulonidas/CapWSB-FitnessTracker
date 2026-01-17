package pl.wsb.fitnesstracker.user.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.wsb.fitnesstracker.user.api.UpdateUserDto;
import pl.wsb.fitnesstracker.user.api.User;
import pl.wsb.fitnesstracker.user.api.UserProvider;
import pl.wsb.fitnesstracker.user.api.UserService;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.List;
import java.time.LocalDate;


@Service
@RequiredArgsConstructor
@Slf4j
class UserServiceImpl implements UserService, UserProvider {

    private final UserRepository userRepository;

    @Override
    public User createUser(final User user) {
        log.info("Creating User {}", user);
        if (user.getId() != null) {
            throw new IllegalArgumentException("User has already DB ID, update is not permitted!");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> getUser(final Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> getUserByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }


    public List<User> findByEmail(String email) {
        return userRepository.findAll()
                .stream()
                .filter(user ->
                        user.getEmail().toLowerCase()
                                .contains(email.toLowerCase()))
                .toList();
    }



    public List<User> findOlderThan(LocalDate date) {
        return userRepository.findAll()
                .stream()
                .filter(user -> user.getBirthdate().isBefore(date))
                .toList();
    }
    @Override
    public User updateUser(Long userId, UpdateUserDto dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new IllegalArgumentException("User not found: " + userId)
                );

        if (dto.firstName() != null) {
            user.updateFirstName(dto.firstName());
        }

        if (dto.lastName() != null) {
            user.updateLastName(dto.lastName());
        }

        if (dto.email() != null) {
            user.updateEmail(dto.email());
        }

        if (dto.birthdate() != null) {
            user.updateBirthdate(dto.birthdate());
        }

        log.info("Updating User {}", user);
        return userRepository.save(user);
    }

}