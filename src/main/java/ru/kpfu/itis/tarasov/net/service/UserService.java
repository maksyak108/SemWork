package ru.kpfu.itis.tarasov.net.service;

import ru.kpfu.itis.tarasov.net.dto.UserDto;
import ru.kpfu.itis.tarasov.net.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    UserDto get(int id);
    void save(User user);
}
