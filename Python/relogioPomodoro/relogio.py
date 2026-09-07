import time

print("===== RELÓGIO POMODORO =====")

tempo_estudo = int(input("Tempo de estudo em minutos (recomendado: 25): "))
tempo_descanso = int(input("Tempo de descanso em minutos (recomendado: 5 a 10): "))
ciclos = int(input("Quantas sessões de estudo? "))

for i in range(1, ciclos + 1):

    print(f"\n📚 Sessão de estudo {i} de {ciclos}")

    for segundos in range(tempo_estudo * 60, 0, -1):
        minutos = segundos // 60
        resto_segundos = segundos % 60
        print(f"Estudo: {minutos:02d}:{resto_segundos:02d}", end="\r")
        time.sleep(1)

    print("\n✅ Tempo de estudo encerrado!")

    # Só faz descanso se ainda houver outra sessão
    if i < ciclos:
        print("☕ Hora do descanso!")

        for segundos in range(tempo_descanso * 60, 0, -1):
            minutos = segundos // 60
            resto_segundos = segundos % 60
            print(f"Descanso: {minutos:02d}:{resto_segundos:02d}", end="\r")
            time.sleep(1)

        print("\n🔔 Descanso encerrado!")

print("\n🎉 Parabéns! Você concluiu todas as sessões de estudo!")