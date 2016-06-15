package example.service;

import example.domain.RolesEntity;
import example.domain.UsersEntity;

import java.util.Collection;
import java.util.List;

public interface UserService {

    public Collection<UsersEntity> getAll();

    public void add(UsersEntity user, List<Long> roleId);

    public void remove(Long userId);

    public void editUser(Long id, String name, String password, String login);

    public List<String> findRolesByUserName(String name);

    public Collection<RolesEntity> getRoles();
}
