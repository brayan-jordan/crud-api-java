ALTER TABLE role_pessoas add CONSTRAINT fk_role
FOREIGN KEY (role_nome_role) REFERENCES role(nome_role);