package com.salesianostriana.bd.securitysample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.salesianostriana.bd.securitysample.model.User;

/**
 * 
 * @author Luismi
 * 
 * Este repositorio nos permite gestionar las entidades de tipo User
 * en la base de datos subyacente. La consulta nos permite obtener
 * un usuario con sus respectivos roles.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u JOIN FETCH u.authorities WHERE u.username = ?1")
	public User findUserWithAuthorities(String username);

}
