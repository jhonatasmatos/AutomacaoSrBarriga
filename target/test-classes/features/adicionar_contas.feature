# language: pt

Funcionalidade: Adicionar conta
	Para que eu possa organizar minhas contas
	Sendo um usuário cadastrado
	Posso adicionar novas contas no meu painel
	
	
	Cenário: Nova Conta
		Dado que estou logado no sistema
		Quando incluo minha conta de "Luz"
		Então devo ver a seguinte mensagem "Conta adicionada com sucesso!"