package com.BookStore.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Bookuser, Long> {
	Bookuser findByUsername(String username);
}
