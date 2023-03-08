package com.nester77.NMS.service.dto.user;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String userName;
    private String password;
    private RoleDto role;
    private boolean isActive;
}
