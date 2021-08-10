CREATE TABLE produtos (
    codigo int not null auto_increment,
    nome varchar(50) not null,
    quantidade int,
    valor_unitario decimal(10, 2) not null,
    primary key (codigo)
);