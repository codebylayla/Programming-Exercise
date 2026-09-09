print("===== CONTROLE DE NOTAS =====")

nome = input("Digite o nome do aluno: ")

notas = []

for numero in range(1, 4):
    while True:
        try:
            nota = float(input(f"Digite a {numero}ª nota: "))

            if 0 <= nota <= 10:
                notas.append(nota)
                break
            else:
                print("A nota deve estar entre 0 e 10.")

        except ValueError:
            print("Digite um número válido.")

media = sum(notas) / len(notas)

if media >= 7:
    situacao = "Aprovado(a)"
elif media >= 5:
    situacao = "Recuperação"
else:
    situacao = "Reprovado(a)"

print("\n===== RESULTADO FINAL =====")
print(f"Aluno(a): {nome}")

print("\nNotas:")
for numero, nota in enumerate(notas, start=1):
    print(f"{numero}ª nota: {nota:.1f}")

print(f"\nMédia final: {media:.2f}")
print(f"Situação: {situacao}")