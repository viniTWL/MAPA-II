# MAPA-II
 Atividade MAPA da matéria de Programação II no curso de ADS da UniCesumar
 
- Este sistema deve contar com uma tela de login e senha com botão entrar, entretanto deve existir também uma opção de "Cadastrar Novo Usuário" para os casos em que um usuário novo esteja acessando o sistema.
- Este sistema deve possuir a tela usando Java SWING e conexão com banco de dados de sua preferência usando JDBC como tipo de conexão.

O programa inicia na tela de login, e o botão redireciona para a tela de cadastro

Requisitos da tela:
Tela de Login: 

    - Ao inserir o login deve executar o seguinte comando no banco:
        SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?
    - Se não retornar nada, quer dizer que o usuário e senha são inválidos e então mostre uma mensagem de "Acesso Negado" na tela.
    - Caso retorne, mostre na tela "Acesso Autorizado"
    
Cadatrar Novo Usuário:

    - Inserir os campos de usuário no banco de dados
    - Pode usar o SQL 
        insert into usuario(nome, login, senha, email) values (?,?,?,?)
    - Ao inserir, mostre uma mensagem "Cadastro efetuado com sucesso" e feche a tela.
    
Use o banco MySQL para a atividade, segue o script para montar a base e a tabela necessária.

CREATE SCHEMA `mapa` ;

CREATE TABLE `mapa`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `login` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
