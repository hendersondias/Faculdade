/* localhost:8080
usuario: user
senha: userpass */

CREATE TABLE livros (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL
);
