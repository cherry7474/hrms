package com.urssystems.hrms.reposorities;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urssystems.hrms.pojos.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findOneByUsername(String username);
}