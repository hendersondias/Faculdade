import numpy as np

# Funções auxiliares
def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def sigmoid_derivative(x):
    return x * (1 - x)

# Dados fictícios: [nota1, nota2] -> aprovado (1) ou reprovado (0)
X = np.array([
    [2, 3],
    [1, 5],
    [2, 4],
    [3, 3],
    [6, 4],
    [7, 5],
    [8, 6],
    [6, 7],
    [5, 8],
    [9, 8]
])

y = np.array([[0], [0], [0], [0], [1], [1], [1], [1], [1], [1]])

# Inicialização de pesos
np.random.seed(42)
input_size = 2
hidden_size = 4
output_size = 1

W1 = np.random.randn(input_size, hidden_size)
b1 = np.zeros((1, hidden_size))

W2 = np.random.randn(hidden_size, output_size)
b2 = np.zeros((1, output_size))

# Hiperparâmetros
epochs = 5000
learning_rate = 0.1

# Treinamento
for epoch in range(epochs):
    # Forward pass
    z1 = np.dot(X, W1) + b1
    a1 = sigmoid(z1)

    z2 = np.dot(a1, W2) + b2
    output = sigmoid(z2)

    # Erro
    error = y - output
    if epoch % 500 == 0:
        print(f"Epoch {epoch} - Erro médio: {np.mean(np.abs(error)):.4f}")

    # Backpropagation
    d_output = error * sigmoid_derivative(output)
    d_hidden = d_output.dot(W2.T) * sigmoid_derivative(a1)

    # Atualizar pesos
    W2 += a1.T.dot(d_output) * learning_rate
    b2 += np.sum(d_output, axis=0, keepdims=True) * learning_rate

    W1 += X.T.dot(d_hidden) * learning_rate
    b1 += np.sum(d_hidden, axis=0, keepdims=True) * learning_rate

# Teste do modelo
print("\nPrevisões após treinamento:")
for i in range(len(X)):
    pred = output[i][0]
    status = "Aprovado" if pred >= 0.5 else "Reprovado"
    print(f"Notas: {X[i]} => {pred:.4f} => {status}")
