package com.github.kolorobot.domain;

import java.util.Collection;

public interface UserRepository {

	boolean hasUser(String username);

	User save(User entity);

	void remove(User entity);

	User findById(long id);

	Collection<User> findAll();

}