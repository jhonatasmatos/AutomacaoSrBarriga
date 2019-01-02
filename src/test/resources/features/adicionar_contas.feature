# language: pt

@adicionarContas
Funcionalidade: Adicionar contas
	Para que eu possa organizar minhas contas
	Sendo um usuário cadastrado
	Posso adicionar novas contas no meu painel
	
	Contexto: Acessar o sistema e navegar para a tela de adicionar contas
		Dado que estou logado no sistema
		E acesso a tela para adicionar contas
		
		Esquema do Cenário: Validar inclusão de contas
			Quando incluo uma conta "<conta>"
			Então devo ver a "<mensagem>"
		
			Exemplos:
				|  conta |             mensagem              |
				|  Luz   | Conta adicionada com sucesso!     |
				|  Luz   | Já existe uma conta com esse nome!|
				|        |      Informe o nome da conta      |
			