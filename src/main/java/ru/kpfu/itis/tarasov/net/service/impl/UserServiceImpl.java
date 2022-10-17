package ru.kpfu.itis.tarasov.net.service.impl;

import ru.kpfu.itis.tarasov.net.dao.Dao;
import ru.kpfu.itis.tarasov.net.dao.impl.UserDaoImpl;
import ru.kpfu.itis.tarasov.net.dto.UserDto;
import ru.kpfu.itis.tarasov.net.model.User;
import ru.kpfu.itis.tarasov.net.service.UserService;
import ru.kpfu.itis.tarasov.net.util.PasswordUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final Dao<User> userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getName(), u.getEmail())
        ).collect(Collectors.toList());
    }

    @Override
    public UserDto get(int id) {
        return null;
    }

    @Override
    public void save(User user) {
        user.setPassword(PasswordUtil.encrypt(user.getPassword()));
        userDao.save(user);
    }
}
