package com.nester77.NMS.service.impl;

import com.nester77.NMS.data.entity.User;
import com.nester77.NMS.data.repository.UserRepository;
import com.nester77.NMS.service.UserService;
import com.nester77.NMS.service.dto.user.UserDto;
import com.nester77.NMS.service.dto.user.UserDtoForSave;
import com.nester77.NMS.service.dto.user.UserDtoForUpdate;
import com.nester77.NMS.service.exception.NmsException;
import com.nester77.NMS.service.exception.NotFoundException;
import com.nester77.NMS.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final String USER_NOT_FOUND_MSG = "User not found";
    private static final String EXCEPTION_EXISTING_USERNAME_MSG = "Username %s already exists in the database";
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDto create(UserDtoForSave dto) {
        Optional<User> existing = userRepository.findByUserName(dto.getUserName());
        if (existing.isPresent()) {
            throw new NmsException(String.format(EXCEPTION_EXISTING_USERNAME_MSG, dto.getUserName()));
        }
        User entity = userMapper.userDtoForSavingToUser(dto);
        entity.setRole(User.Role.USER);
        entity.setActive(true);
        User created = userRepository.save(entity);
        return userMapper.userToUserDto(created);
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::userToUserDto);
    }

    @Override
    public UserDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_MSG));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto update(UserDtoForUpdate dto) {
        Optional<User> existing = userRepository.findByUserName(dto.getUserName());
        if (existing.isPresent() && !existing.get().getId().equals(dto.getId())) {
            throw new NmsException(String.format(EXCEPTION_EXISTING_USERNAME_MSG, dto.getUserName()));
        }
        User newUser = userMapper.userDtoForUpdatingToUser(dto);
        User updated = userRepository.save(newUser);
        return userMapper.userToUserDto(updated);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND_MSG));
        if (!user.isActive()) {
            throw new NotFoundException(USER_NOT_FOUND_MSG);
        }
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
