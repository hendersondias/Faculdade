class SistemaEspecialista:
    def __init__(self):
        self.atividades = {
            "musculação": ["fortalecimento muscular", "ganho de massa"],
            "natação": ["condicionamento físico","baixo impacto"],
            "hidroginástica": ["condicionamento físico", "reabilitação"],
            "ginástica localizada": ["tonificação muscular", "flexibilidade"],
            "ginástica aeróbica": ["queima de calorias", "condicionamento cardiovascular"]
        }
    def iniciar(self):
        print("Sistema Especialista Atividade Física")
        print("Responda as perguntas a seguir.")
        self.fazer_perguntas()
    def fazer_perguntas(self):
        print("1. Você prefere atividades físicas que envolvam o uso de equipamentos?(sim/não)")
        resposta1 = input().lower()
        print("2. Qual seu objetivo principal? (fortalecimento muscular, condicionamento físico, reabilitação, tonificação muscular, queima de caloria)")
        resposta2 = input().lower()
        #Perguntas sobre restrições físicas específicas
        restricoes_fisicas = {}
        for atividade in self.atividades.keys():
            restricao_fisica = input(f"Você tem alguma restrição física para {atividade}? (sim/não): ").lower()
            if restricao_fisica == "sim":
                restricoes_fisicas[atividade] = input("Descreva sua restrição física: ")
        atividades_sugeridas = self.selecionar_atividades(resposta1, resposta2, restricoes_fisicas)
        print("\nCom base nas suas respostas, recomendamos as seguintes atividades físicas: ")
        for atividade in atividades_sugeridas:
            print("-",atividade)

    def selecionar_atividades(self,resposta1, resposta2, restricoes_fisicas):
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
                        print(f"Devido à sua restrição física para {atividade}, não recomendamos esta atividade.")
        return atividades_sugeridas
#Criar o objeto de Sistema Especialista e iniciar
sistema = SistemaEspecialista()
sistema.iniciar()