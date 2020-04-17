CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	logradouro varchar(50),
	numero BIGINT,
	complemento varchar(50),
	bairro varchar(50),
	cep varchar(50),
	cidade varchar(50),
	estado  varchar(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into pessoa (nome,logradouro,numero,complemento,bairro,cep,cidade,estado) values ('João','Rua 1', 120, 'Casa A','Jardim América','118998989', 'Registro', 'SP');