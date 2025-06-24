import networkx as nx
import matplotlib.pyplot as plt


grafo = nx.Graph()
arestas = [
    ('Arad', 'Zerind', 75), ('Arad', 'Sibiu', 140), ('Arad', 'Timisoara', 118),
    ('Zerind', 'Oradea', 71), ('Oradea', 'Sibiu', 151),
    ('Sibiu', 'Fagaras', 99), ('Sibiu', 'Rimnicu Vilcea', 80),
    ('Timisoara', 'Lugoj', 111), ('Lugoj', 'Mehadia', 70),
    ('Mehadia', 'Drobeta', 75), ('Drobeta', 'Craiova', 120),
    ('Craiova', 'Pitesti', 138), ('Craiova', 'Rimnicu Vilcea', 146),
    ('Rimnicu Vilcea', 'Pitesti', 97), ('Fagaras', 'Bucharest', 211),
    ('Pitesti', 'Bucharest', 101), ('Bucharest', 'Giurgiu', 90),
    ('Bucharest', 'Urziceni', 85), ('Urziceni', 'Vaslui', 142),
    ('Urziceni', 'Hirsova', 98), ('Hirsova', 'Eforie', 86),
    ('Vaslui', 'Iasi', 92), ('Iasi', 'Neamt', 87)
]

for origem, destino, distancia in arestas:
    grafo.add_edge(origem, destino, weight=distancia)


heuristica = {
    'Arad': 366, 'Zerind': 374, 'Oradea': 380, 'Sibiu': 253,
    'Timisoara': 329, 'Lugoj': 244, 'Mehadia': 241, 'Drobeta': 242,
    'Craiova': 160, 'Rimnicu Vilcea': 193, 'Fagaras': 176, 'Pitesti': 100,
    'Bucharest': 0, 'Giurgiu': 77, 'Urziceni': 80, 'Hirsova': 151,
    'Eforie': 161, 'Vaslui': 199, 'Iasi': 226, 'Neamt': 234
}


pedagios = {
    'Arad': 5, 'Zerind': 3, 'Oradea': 4, 'Sibiu': 6, 'Timisoara': 4,
    'Lugoj': 3, 'Mehadia': 2, 'Drobeta': 4, 'Craiova': 5, 'Rimnicu Vilcea': 6,
    'Fagaras': 7, 'Pitesti': 4, 'Bucharest': 0, 'Giurgiu': 3, 'Urziceni': 3,
    'Hirsova': 4, 'Eforie': 2, 'Vaslui': 3, 'Iasi': 5, 'Neamt': 4
}
postos_gasolina = {'Arad', 'Sibiu', 'Craiova', 'Bucharest', 'Iasi'}


def funcao_heuristica(cidade):
    custo = heuristica[cidade] + pedagios.get(cidade, 0)
    if cidade in postos_gasolina:
        custo -= 10  # Presença de posto reduz o custo estimado
    return custo


def a_estrela(inicio, destino):
    fila = [(funcao_heuristica(inicio), 0, inicio, [])]

    while fila:
        fila.sort()
        _, custo, cidade, caminho = fila.pop(0)

        if cidade == destino:
            return caminho + [cidade]

        if cidade not in caminho:
            caminho = caminho + [cidade]

            for vizinho in grafo.neighbors(cidade):
                distancia = grafo[cidade][vizinho]['weight']
                novo_custo = custo + distancia
                heuristica_total = novo_custo + funcao_heuristica(vizinho)
                fila.append((heuristica_total, novo_custo, vizinho, caminho))

    return None


inicio = 'Arad'
destino = 'Bucharest'
caminho = a_estrela(inicio, destino)
print("Melhor caminho:", caminho)


pos = nx.spring_layout(grafo)
nx.draw(grafo, pos, with_labels=True, node_color='lightblue', node_size=2000, font_size=10, font_color='black')
labels = nx.get_edge_attributes(grafo, 'weight')
nx.draw_networkx_edge_labels(grafo, pos, edge_labels=labels)
plt.title("Mapa das Cidades")
plt.show()
