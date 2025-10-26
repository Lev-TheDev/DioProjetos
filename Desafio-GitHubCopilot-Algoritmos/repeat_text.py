# Vamos solicitar uma string e um número inteiro como entrada. Depois teremos que retornar a string repetida o número de vezes indicado pelo número inteiro.
texto = input("Digite um texto: ")
numero = int(input("Digite um número inteiro: "))
# adicionando espaços entre as repetições
resultado = (texto + " ") * numero
print("Resultado:", resultado)