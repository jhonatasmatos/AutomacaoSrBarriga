# language: pt

@novoUsuario	
Funcionalidade: Cadastrar usuário
  Para que eu possa ter um cadastrado
  Sendo um usuário comum
  Posso cadastrar um novo usuário
	
  Esquema do Cenário: Cadastro com campos obrigatórios
  	Dado que acesso a tela para incluir um novo usuário
    Quando preencho as informações "<nome>" e "<email>" e "<senha>"
    E finalizo o cadastro
    Então devo ver a mensagem "<mensagem>"

    Exemplos: 
      | nome 	      | email               | senha   | mensagem                   	|
      | Fulano 02   | fulano_02@teste.com | teste123| Usuário inserido com sucesso|
      |             |teste00@teste.com    |teste123	|Nome é um campo obrigatório  |
			| Fulano nome | 										|teste123	|Email é um campo obrigatório |
			| Fulano nome |teste00@teste.com    | 				|Senha é um campo obrigatório |