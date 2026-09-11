import time
from datetime import datetime

sessoes = []

print("=" * 40)
print("     BEM-VINDO À SALA DE ESTUDO")
print("=" * 40)

nome = input("\nDigite seu nome: ")

while True:
    print("\n" + "=" * 40)
    print("             MENU PRINCIPAL")
    print("=" * 40)
    print("1 - Iniciar uma sessão de estudo")
    print("2 - Ver histórico de estudos")
    print("3 - Ver tempo total estudado")
    print("4 - Sair")

    opcao = input("\nEscolha uma opção: ")

    if opcao == "1":
        materia = input("\nQual matéria você vai estudar? ")

        try:
            minutos = int(input("Quantos minutos deseja estudar? "))

            if minutos <= 0:
                print("\nDigite um tempo maior que zero.")
                continue

            segundos = minutos * 60

            print(f"\nSessão iniciada!")
            print(f"Matéria: {materia}")
            print(f"Tempo: {minutos} minuto(s)")
            print("Pressione Ctrl + C para interromper.\n")

            inicio = datetime.now()

            try:
                while segundos > 0:
                    minutos_restantes = segundos // 60
                    segundos_restantes = segundos % 60

                    print(
                        f"\rTempo restante: "
                        f"{minutos_restantes:02d}:{segundos_restantes:02d}",
                        end=""
                    )

                    time.sleep(1)
                    segundos -= 1

                print("\n\nParabéns! Sua sessão foi concluída! 🎉")

                sessoes.append({
                    "materia": materia,
                    "tempo": minutos,
                    "data": inicio.strftime("%d/%m/%Y %H:%M")
                })

            except KeyboardInterrupt:
                print("\n\nSessão interrompida.")
                print("O estudo não foi adicionado ao histórico.")

        except ValueError:
            print("\nDigite apenas números para informar os minutos.")

    elif opcao == "2":
        print("\n" + "=" * 40)
        print("          HISTÓRICO DE ESTUDOS")
        print("=" * 40)

        if len(sessoes) == 0:
            print("\nNenhuma sessão foi concluída ainda.")

        else:
            for numero, sessao in enumerate(sessoes, start=1):
                print(f"\nSessão {numero}")
                print(f"Matéria: {sessao['materia']}")
                print(f"Tempo: {sessao['tempo']} minuto(s)")
                print(f"Data: {sessao['data']}")

    elif opcao == "3":
        total = 0

        for sessao in sessoes:
            total += sessao["tempo"]

        print("\n" + "=" * 40)
        print("          TEMPO TOTAL ESTUDADO")
        print("=" * 40)
        print(f"\nVocê estudou {total} minuto(s) no total.")

    elif opcao == "4":
        print(f"\nAté mais, {nome}! Bons estudos! 📚")
        break

    else:
        print("\nOpção inválida. Tente novamente.")
