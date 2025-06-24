class SistemaEspecialista:
    def __init__(self):
        self.atividades = {
            "musculação" : ["fortalecimento muscular", "ganho de massa"],
            "natação" : ["condicionamento físico", "baixo impacto"],
            "hidroginástica" : ["condicionamento físico", "reabilitação"],
            "ginástica localizada" : ["tonificação muscular", "flexibilidade"],
            "ginástica aeróbica" : ["queima de calorias", "condicionamento cardiovascular"]
        }
    def iniciar(self):
        print("Bem-vindo ao Sistema Especialista em Atividade Física")
        print("Responda algumas perguntas para determinar as atividades ideais para você.")
        self.fazer_perguntas()
    def fazer_perguntas(self):
        print("Perguntas:")
        print("1. Você prefere atividades que usem equipamentos? (sim/não):")
        resposta1 = input().lower()
        print("2. Qual seu objetivo? (fortalecimento muscular, condicionamento físico,"
              "reabilitação, tonificação muscular, queima de calorias)")
        resposta2 = input().lower()

        restricoes_fisicas = {}
        for atividade in self.atividades.keys():
            restricao_fisica = input("Você tem alguma restrição física "
                                     "para {atividade}? (sim/não): ").lower()
            if restricao_fisica == "sim":
                restricoes_fisicas[atividade] = input("Por favor, "
                                                      "descreva sua restrição: ")
        atividades_sugeridas = self.selecionar_atividades(resposta1, resposta2, restricoes_fisicas)
        print("\nCom base nas suas respostas, recomendamos as seguintes atividades físicas:")
        for atividade in atividades_sugeridas:
            print("-",atividade)

    def selecionar_atividades(self, resposta1, resposta2, restricoes_fisicas):
        atividades_sugeridas = []
        for atividade, objetivos in self.atividades.items():
            if resposta1 == "sim" and atividade != "natação" and atividade != "hidroginástica":
                atividades_sugeridas.append(atividade)
            elif resposta1 == "não" and (atividade == "natação" or atividade == "hidroginástica"):
                atividades_sugeridas.append(atividade)
            for objetivo in objetivos:
                if resposta2 == objetivo:
                    if atividade not in restricoes_fisicas:
                        atividades_sugeridas.append(atividade)
                    else:
                        print("Devido à sua restrição física para {atividade}, não recomendamos esta atividade.")
        return atividades_sugeridas
sistema = SistemaEspecialista()
sistema.iniciar()