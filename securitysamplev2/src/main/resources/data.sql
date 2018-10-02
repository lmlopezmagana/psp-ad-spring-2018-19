insert into users(username,password,enabled)
	values('admin','$2a$04$dJ5YWbG5dE0wuPaPZWQDHu2oM/K2luEFhxsztxM6jhNsaU4iT8lvO',true);
	
-- Se puede generar la contraseña en BCrypt en https://www.dailycred.com/article/bcrypt-calculator 

	
insert into authorities(id, username,authority) 
	values(1,'admin','ROLE_ADMIN');