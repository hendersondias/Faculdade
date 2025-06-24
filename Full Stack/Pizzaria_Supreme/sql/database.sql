-- Criação do banco de dados
CREATE DATABASE Pizzaria_Supreme;

-- Seleciona o banco de dados
USE Pizzaria_Supreme;

-- Tabela para usuários
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- Tabela para pizzas (cardápio)
CREATE TABLE pizzas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    imagem VARCHAR(255) NOT NULL
);

-- Tabela para pedidos
CREATE TABLE pedidos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    pizza_id INT NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id),
    FOREIGN KEY (pizza_id) REFERENCES pizzas(id)
);

-- Alterar tabela pedidos
ALTER TABLE pedidos(
ADD COLUMN rua VARCHAR(255) NOT NULL,
ADD COLUMN complemento VARCHAR(255) DEFAULT NULL,
ADD COLUMN bairro VARCHAR(255) NOT NULL,
ADD COLUMN cep VARCHAR(10) NOT NULL;
);