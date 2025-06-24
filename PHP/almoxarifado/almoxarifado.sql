-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 21-Maio-2024 às 01:28
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `almoxarifado`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_ferramentas`
--

CREATE TABLE `tb_ferramentas` (
  `cod_ferramenta` int(10) UNSIGNED NOT NULL,
  `nome_ferramenta` varchar(80) NOT NULL,
  `marca_ferramenta` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE `tb_usuario` (
  `cod_usuario` int(10) UNSIGNED NOT NULL,
  `login_usuario` varchar(30) NOT NULL,
  `senha_usuario` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario_ferramentas`
--

CREATE TABLE `tb_usuario_ferramentas` (
  `cod_usuario_ferranenta` int(10) UNSIGNED NOT NULL,
  `cod_usuario` int(10) UNSIGNED NOT NULL,
  `cod_ferramenta` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  ADD PRIMARY KEY (`cod_ferramenta`);

--
-- Índices para tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  ADD PRIMARY KEY (`cod_usuario`);

--
-- Índices para tabela `tb_usuario_ferramentas`
--
ALTER TABLE `tb_usuario_ferramentas`
  ADD KEY `cod_ferramenta` (`cod_ferramenta`),
  ADD KEY `cod_usuario` (`cod_usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_ferramentas`
--
ALTER TABLE `tb_ferramentas`
  MODIFY `cod_ferramenta` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tb_usuario`
--
ALTER TABLE `tb_usuario`
  MODIFY `cod_usuario` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tb_usuario_ferramentas`
--
ALTER TABLE `tb_usuario_ferramentas`
  ADD CONSTRAINT `tb_usuario_ferramentas_ibfk_1` FOREIGN KEY (`cod_ferramenta`) REFERENCES `tb_ferramentas` (`cod_ferramenta`),
  ADD CONSTRAINT `tb_usuario_ferramentas_ibfk_2` FOREIGN KEY (`cod_usuario`) REFERENCES `tb_usuario` (`cod_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
