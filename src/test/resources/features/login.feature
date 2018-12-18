# language: pt

Funcionalidade: Login
	Para que eu possa gerenciar meus pagamentos
	Sendo um usuário cadastrado
	Posso logar no sistema
	
	@login
	Cenário: Login do usuário
		Quando faço login com "jhonatas-teste@teste.com" e "teste123"
		Então sou autenticado com sucesso
		E sou redirecionado para a home de contas com a mensagem "Bem vindo, Jhonatas Teste!"