package com.website.ecommerce.dao;

import com.website.ecommerce.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao  extends CrudRepository<User, String> {
}

