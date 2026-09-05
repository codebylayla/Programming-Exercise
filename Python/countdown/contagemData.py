from datetime import datetime

# Data atual
hoje = datetime.now()

print("=== Countdown de Datas ===")

# Entrada da data
data_usuario = input("Digite uma data (dd/mm/aaaa): ")

try:
    data_alvo = datetime.strptime(data_usuario, "%d/%m/%Y")

    diferenca = data_alvo - hoje
    dias = diferenca.days

    print("\n========================")

    if dias > 0:
        print(f"Faltam {dias} dias para {data_alvo.strftime('%d/%m/%Y')}!")
    elif dias < 0:
        print(f"Já se passaram {abs(dias)} dias desde {data_alvo.strftime('%d/%m/%Y')}!")
    else:
        print("A data é hoje!")

except ValueError:
    print("Data inválida! Utilize o formato dd/mm/aaaa.")