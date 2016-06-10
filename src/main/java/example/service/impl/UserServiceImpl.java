package example.service.impl;

import example.dao.UserDao;

import example.domain.UsersEntity;
import example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

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
    public void add(UsersEntity user) {
        userDao.add(user);
    }

    @Override
    public void remove(Long userId) {
        userDao.remove(userId);
    }

    @Override
    public ArrayList<String> findUserByName(String name) {
        return userDao.findUserByName(name);
    }

    @Override
    public void editUser(Long id,String name,String password){
         userDao.editUser(id,name,password);
    }
}
