insert into users(username,password,enabled)
	values('admin','$2a$04$dJ5YWbG5dE0wuPaPZWQDHu2oM/K2luEFhxsztxM6jhNsaU4iT8lvO',true);
insert into users(username,password,enabled)
	values('luismi','$2a$04$QOIfbf3aoT9XG2iEcSOKqubufKkhcPF396YSNZUmX3YO5KX.EvfLK',true);	
-- Se puede generar la contraseña en BCrypt en https://www.dailycred.com/article/bcrypt-calculator 

	
insert into authorities(username,authority) 
	values('admin','ROLE_ADMIN');
insert into authorities(username,authority)
	values('luismi','ROLE_USER');