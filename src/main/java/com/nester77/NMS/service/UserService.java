package com.nester77.NMS.service;

import com.nester77.NMS.service.dto.user.UserDto;
import com.nester77.NMS.service.dto.user.UserDtoForSave;
import com.nester77.NMS.service.dto.user.UserDtoForUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserDto create(UserDtoForSave dto);

    Page<UserDto> getAll(Pageable pageable);

    UserDto getById(Long id);

    UserDto update(UserDtoForUpdate dto);

    void delete(Long id);
}
