package example.controller;


import example.domain.RolesEntity;
import example.domain.UsersEntity;
import example.service.UserService;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/user")
    public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<UsersEntity> getAll() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Collection<UsersEntity> add(@RequestBody UsersEntity user,@RequestParam ArrayList<Long> rolesId){
        userService.add(user,rolesId);
        return getAll();
    }

    @RequestMapping(method = RequestMethod.GET,value="/find")
    public @ResponseBody ArrayList<String> find(@RequestParam String name) {
        return   userService.findUserByName(name);
    }

    @RequestMapping(method = RequestMethod.GET,value="/edit")
    public Collection<UsersEntity> update(@RequestParam Long userId,@RequestParam String userName,@RequestParam String userPassword,@RequestParam String userLogin) {
        userService.editUser(userId,userName,userPassword,userLogin);
        return getAll();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Collection<UsersEntity> remove(@RequestParam Long userId) {
        userService.remove(userId);
        return getAll();
    }

        @RequestMapping(method = RequestMethod.GET,value="/role")
        public Collection<RolesEntity> getRoles() {return userService.getRoles();}

}
