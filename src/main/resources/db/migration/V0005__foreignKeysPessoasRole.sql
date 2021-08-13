ALTER TABLE role_pessoas add CONSTRAINT fk_pessoas
FOREIGN KEY(pessoas_codigo) REFERENCES pessoa(codigo);