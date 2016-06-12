package example.dao;

import example.domain.RolesEntity;
import example.domain.UsersEntity;

import java.util.ArrayList;
import java.util.Collection;


public interface UserDao {

    public Collection<UsersEntity> getAll();

    public void add(UsersEntity user,ArrayList<Long> roleId);

    public void remove(Long userId);

    public ArrayList<String> findUserByName(String name);

    public void editUser(Long id,String name,String password,String login);

    public Collection<RolesEntity> getRoles();

}
