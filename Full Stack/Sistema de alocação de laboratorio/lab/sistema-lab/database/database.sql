CREATE DATABASE sistema_laboratorios;
USE sistema_laboratorios;

-- Usuários: Diretor, Coordenador, TI
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome_completo VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    tipo_usuario ENUM('Diretor', 'Coordenador', 'TI') NOT NULL
);

-- Laboratórios
CREATE TABLE laboratorio (
    id_laboratorio INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    qtd_computadores INT NOT NULL
);

-- Aplicativos
CREATE TABLE aplicativo (
    id_aplicativo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

-- Aplicativos instalados em laboratórios (N:N)
CREATE TABLE laboratorio_aplicativo (
    id_laboratorio INT,
    id_aplicativo INT,
    PRIMARY KEY (id_laboratorio, id_aplicativo),
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorio(id_laboratorio),
    FOREIGN KEY (id_aplicativo) REFERENCES aplicativo(id_aplicativo)
);

-- Disciplinas
CREATE TABLE disciplina (
    id_disciplina INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    qtd_alunos INT NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    duracao INT NOT NULL,
    id_coordenador INT NOT NULL,
    data_alocacao DATE NOT NULL,
    FOREIGN KEY (id_coordenador) REFERENCES usuario(id_usuario)
);
-- Requisitos de software por disciplina (N:N)
CREATE TABLE disciplina_aplicativo (
    id_disciplina INT,
    id_aplicativo INT,
    PRIMARY KEY (id_disciplina, id_aplicativo),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina),
    FOREIGN KEY (id_aplicativo) REFERENCES aplicativo(id_aplicativo)
);

-- Alocações de laboratório feitas pelo coordenador e aprovadas pelo diretor
CREATE TABLE alocacao (
    id_alocacao INT AUTO_INCREMENT PRIMARY KEY,
    id_laboratorio INT NOT NULL,
    id_disciplina INT NOT NULL,
    status ENUM('Pendente', 'Aprovado', 'Rejeitado') DEFAULT 'Pendente',
    data_alocacao DATE NOT NULL,
    FOREIGN KEY (id_laboratorio) REFERENCES laboratorio(id_laboratorio),
    FOREIGN KEY (id_disciplina) REFERENCES disciplina(id_disciplina)

);

-- Inserir credencial padrão do Diretor
INSERT INTO usuario (nome_completo, email, senha, tipo_usuario) VALUES ('Diretor Geral','diretor@lab.com','Diretor456','Diretor'); 
