package example.service;

import example.domain.UsersEntity;

import java.util.ArrayList;
import java.util.Collection;

public interface UserService {

    public Collection<UsersEntity> getAll();

    public void add(UsersEntity user);

    public void remove(Long userId);

    public void editUser(Long id,String name,String password);

    public ArrayList<String> findUserByName(String name);
}
