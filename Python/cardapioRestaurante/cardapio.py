
print("====== CARDÁPIO ======")
print("\nPratos:")
print("1 - Frango Grelhado .......... R$ 25,00")
print("2 - Bife Acebolado ........... R$ 35,00")
print("3 - Costelinha Suína ......... R$ 32,00")
print("4 - Lasanha Vegana ........... R$ 28,00")
print("0 - Não desejo prato")

print("\nRefrigerantes:")
print("1 - Coca-Cola ................ R$ 7,00")
print("2 - Guaraná .................. R$ 6,00")
print("3 - Fanta Laranja ............ R$ 6,00")
print("0 - Não desejo refrigerante")

total = 0
prato = "Nenhum"
refrigerante = "Nenhum"

# Escolha do prato
opcao_prato = int(input("\nEscolha o prato: "))

if opcao_prato == 1:
    prato = "Frango Grelhado"
    total += 25
elif opcao_prato == 2:
    prato = "Bife Acebolado"
    total += 35
elif opcao_prato == 3:
    prato = "Costelinha Suína"
    total += 32
elif opcao_prato == 4:
    prato = "Lasanha Vegana"
    total += 28
elif opcao_prato == 0:
    prato = "Nenhum"
else:
    print("Opção inválida!")

# Escolha do refrigerante
opcao_refri = int(input("Escolha o refrigerante: "))

if opcao_refri == 1:
    refrigerante = "Coca-Cola"
    total += 7
elif opcao_refri == 2:
    refrigerante = "Guaraná"
    total += 6
elif opcao_refri == 3:
    refrigerante = "Fanta Laranja"
    total += 6
elif opcao_refri == 0:
    refrigerante = "Nenhum"
else:
    print("Opção inválida!")

# Resumo
print("\n====== PEDIDO ======")
print("Prato:", prato)
print("Refrigerante:", refrigerante)
print(f"Total a pagar: R$ {total:.2f}")