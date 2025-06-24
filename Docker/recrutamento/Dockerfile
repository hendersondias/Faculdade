FROM php:8.2-apache

# Instalar dependências e extensões do PHP necessárias
RUN docker-php-ext-install mysqli pdo pdo_mysql

RUN docker-php-ext-enable mysqli

# Habilitar o mod_rewrite do Apache (caso necessário)
RUN a2enmod rewrite
