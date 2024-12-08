package com.website.ecommerce.service;

import com.website.ecommerce.dao.RoleDao;
import com.website.ecommerce.dao.UserDao;
import com.website.ecommerce.entity.Role;
import com.website.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){
        return userDao.save(user);
    }

    public void initRolesAndUser() {
        Role adminRole = new Role();
        adminRole.setRoleName("admin");
        adminRole.setRoleDescription("Admin role for an Application");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("user");
        userRole.setRoleDescription("Default role for newly created user");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setUserFirstName("param");
        user.setUserLastName("tatiya");
        user.setUserName("ParamTatiya02");
        user.setUserPassword("param");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }

}
