package com.nester77.NMS.service.mapper;


import com.nester77.NMS.data.entity.User;
import com.nester77.NMS.service.dto.user.UserDto;
import com.nester77.NMS.service.dto.user.UserDtoForSave;
import com.nester77.NMS.service.dto.user.UserDtoForUpdate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoForSavingToUser(UserDtoForSave userDtoForSaving);

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    User userDtoForUpdatingToUser(UserDtoForUpdate userDtoForUpdating);
}
