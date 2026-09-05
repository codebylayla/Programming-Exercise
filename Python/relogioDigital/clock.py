from datetime import datetime
import time

print("=== RELÓGIO DIGITAL ===")
print("Pressione Ctrl + C para encerrar.\n")

while True:
    hora_atual = datetime.now().strftime("%H:%M:%S")

    print(f"\rHora atual: {hora_atual}", end="")

    time.sleep(1)