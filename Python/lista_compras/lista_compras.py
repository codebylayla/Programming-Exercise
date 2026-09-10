id="r1y5pq"

id="k7b2xm"
lista = []

while True:
    print("\n===== LISTA DE COMPRAS =====")
    print("1 - Adicionar produto")
    print("2 - Ver lista")
    print("3 - Remover produto")
    print("4 - Sair")

    opcao = input("\nEscolha uma opção: ")

    if opcao == "1":
        produto = input("Digite o nome do produto: ")
        lista.append(produto)
        print(f"{produto} foi adicionado à lista!")

    elif opcao == "2":
        print("\n===== PRODUTOS =====")

        if len(lista) == 0:
            print("A lista está vazia.")
        else:
            for numero, produto in enumerate(lista, start=1):
                print(f"{numero} - {produto}")

    elif opcao == "3":
        if len(lista) == 0:
            print("Não há produtos para remover.")

        else:
            print("\n===== PRODUTOS =====")

            for numero, produto in enumerate(lista, start=1):
                print(f"{numero} - {produto}")

            try:
                numero = int(input("\nDigite o número do produto: "))

                if numero >= 1 and numero <= len(lista):
                    produto_removido = lista.pop(numero - 1)
                    print(f"{produto_removido} foi removido!")
                else:
                    print("Número inválido.")

            except ValueError:
                print("Digite apenas números.")

    elif opcao == "4":
        print("\nLista encerrada. Até mais!")
        break

    else:
        print("Opção inválida. Tente novamente.")
