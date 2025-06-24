import networkx as nx
class GrafoCidades:
    def __init__(self):
        self.grafo = nx.Graph()
    def inserir_cidades(self,cidade):
        self.grafo.add_node(cidade)
    def conectar_cidades(self, cidade_origem, cidade_destino):
        self.grafo.add_edge(cidade_origem, cidade_destino)
    def caminhamento_amplitude(self, cidade_inicial):
        try:
            caminho = list(nx.bfs_edges(self.grafo, source=cidade_inicial))
            return caminho
        except nx.NetworkXError:
            return None
    def caminhamento_profundidade(self, cidade_inicial):
        try:
            caminho = list(nx.dfs_edges(self.grafo, source=cidade_inicial))
            return caminho
        except nx.NetworkXError:
            return None
    def buscar_caminho(self, cidade_inicial, cidade_final):
        try:
            caminho = nx.shortest_path(self.grafo, source=cidade_inicial, target=cidade_final)
            return caminho
        except nx.NetworkXNoPath:
            return None
def main():
    grafo_cidades = GrafoCidades()
    while True:
        print("1. Inserir Cidades")
        print("2. Conectar Cidades")
        print("3. Caminhamento em Amplitudade")
        print("4. Caminhamento em Profundidade")
        print("5. Buscar caminho entre cidades")
        print("6. Sair")
        escolha = int(input("Escolha uma opção: "))
        if escolha == 1:
            cidade = input("Digite o nome da cidade: ")
            grafo_cidades.inserir_cidades(cidade)
        elif escolha == 2:
            cidade_origem = input("Digite a cidade de origem: ")
            cidade_destino = input("Digite a cidade de destino: ")
            grafo_cidades.conectar_cidades(cidade_origem, cidade_destino)
        elif escolha == 3:
            cidade_inicial = input("Digite a cidade inicial para caminhamento em amplitudade: ")
            resultado = grafo_cidades.caminhamento_amplitude(cidade_inicial)
            print("Caminhamento em Amplitudade: ", resultado)
        elif escolha == 4:
            cidade_inicial = input("Digite a cidade inicial para caminhamento em amplitudade: ")
            resultado = grafo_cidades.caminhamento_profundidade(cidade_inicial)
            print("Caminhamento em Profundidade: ", resultado)
        elif escolha == 5:
            cidade_inicial = input("Digite a cidade inicial: ")
            cidade_final = input("Digite a cidade final: ")
            resultado = grafo_cidades.buscar_caminho(cidade_inicial, cidade_final)
            if resultado:
                print("Caminho encontrado: ", resultado)
            else:
                print("Não existe caminho entre cidades")
        elif escolha == 6:
            print("Programa encerrado")
            break
        else:
            print("Opção Inválida")

if __name__ == "__main__":
    main()