# language: pt

@login
Funcionalidade: Login
	Para que eu possa gerenciar meus pagamentos
	Sendo um usuário cadastrado
	Posso logar no sistema

	Contexto: Home
		Dado que acesso o sistema
		
		Esquema do Cenário: Deve validar usuário e senha
			Quando preencho "<email>" e "<senha>"
			E clico em Entrar
			Então devo ver a seguinte "<mensagem>"
		
		Exemplos:
			|        email             |   senha   |           mensagem                 |
			| jhonatas-teste@teste.com | teste123  | Bem vindo, Jhonatas Teste!         |
			| jhonatas-teste@teste.com |           | Senha é um campo obrigatório       |
			|                     	   | teste123  | Email é um campo obrigatório       |
			| jhonatas-teste@teste.com | teste124  | Problemas com o login do usuário   |
