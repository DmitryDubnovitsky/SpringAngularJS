package example.dao.impl;

import example.dao.UserDao;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import example.domain.UsersEntity;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(UsersEntity user) {entityManager.persist(user);}

    @Override
    public Collection<UsersEntity> getAll() {
        return entityManager.createQuery("from UsersEntity", UsersEntity.class).getResultList();
    }

    @Override
    public void remove(Long userId) {
        UsersEntity user = entityManager.find(UsersEntity.class, userId);
        if (null != user) {
            entityManager.remove(user);
        }
    }

    @Override
    public  ArrayList<String> findUserByName(String name) {

        Query q = entityManager.createQuery
         (String.format("select name from RolesEntity  where id in (select  roleId from UserRolesEntity where userId in (select id from  UsersEntity where name= :name))"));
         q.setParameter("name",name);
          ArrayList<String> result= (ArrayList<String>) q.getResultList();
          return  result;
    }

    @Override
    public  void editUser(Long id,String name,String password){
        UsersEntity user = entityManager.find(UsersEntity.class, id);
        user.setName(name);
        user.setPassword(password);
        entityManager.merge(user);

    }
}
