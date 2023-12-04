use  imobiliariabd_m3;
-- Tabela TipoImovel
CREATE TABLE TipoImovel (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50)
);

-- Tabela Proprietario
CREATE TABLE Proprietario (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(100),
    Telefone INT(20),
    Email VARCHAR(200),
    senha VARCHAR(128),
    CPF INT(11)
);

-- Tabela Corretor
CREATE TABLE Corretor (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    imobiliaria_nome VARCHAR(100),
    nome VARCHAR(100),
    CPF INT(10),
    CRECI INT(10),
    telefone INT(20),
    senha VARCHAR(128),
    email VARCHAR(200)
);

-- Tabela Endereco
CREATE TABLE Endereco (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(200),
    bairro VARCHAR(200),
    CEP INT(10),
    numero INT(20),
    complemento VARCHAR(50)
);

-- Tabela Imovel
CREATE TABLE Imovel (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Id_prop INT,
    Id_corretor INT,
    Id_tipo INT,
    Id_endereco INT,
    tamanho FLOAT,
    preco FLOAT,
    FOREIGN KEY (Id_prop) REFERENCES Proprietario(Id),
    FOREIGN KEY (Id_corretor) REFERENCES Corretor(Id),
    FOREIGN KEY (Id_tipo) REFERENCES TipoImovel(Id),
    FOREIGN KEY (Id_endereco) REFERENCES Endereco(Id)
);

