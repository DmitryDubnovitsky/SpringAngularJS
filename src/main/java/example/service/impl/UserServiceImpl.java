package example.service.impl;

import example.dao.UserDao;

import example.domain.RolesEntity;
import example.domain.UsersEntity;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Collection<UsersEntity> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(UsersEntity user, List<Long> roleId) {
        userDao.add(user, roleId);
    }

    @Override
    public void remove(Long userId) {
        userDao.remove(userId);
    }

    @Override
    public List<String> findRolesByUserName(String name) {
        return userDao.findRolesByUserName(name);
    }

    @Override
    public Collection<RolesEntity> getRoles() {
        return userDao.getRoles();
    }

    @Override
    public void editUser(Long id, String name, String password, String login) {
        userDao.editUser(id, name, password, login);
    }
}
