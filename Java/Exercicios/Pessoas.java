import java.util.Scanner; /*Importa a biblioteca para leitura do teclado*/

public class Pessoas
{
  /*Cria os atributos privados (só são acessiveis de dentro da classe
   * com seus valores padrões
   */
  private String nome = "";
  private int idade = 0;
  private float peso = 0.0f, altura = 0.0f;
  
  /*Retorna o valor do atributo nome, se o mesmo estiver em branco 
   * retorna a frase "Nome não informado"
   */
  String getNome(){
      if ( nome == "" ){
          return "Nome não informado";
      }
      else {
         return nome; 
      }
  }
  
  /*Se o valor recebido não for vazio, grava o mesmo no atributo nome*/
  void setNome(String nome){
      if ( nome != "" ){
          this.nome = nome;
      }
  }
  
  /*Retorna o valor do atributo idade*/
  int getIdade(){
      return idade;
  }
  
  /*Grava o valor recebido no atributo idade, apenas se o mesmo for maior
   * ou igual a zero e menor que 150
   */
  void setIdade(int idade){
      if (idade >=0 && idade < 150 ) {
          this.idade = idade;
      }
  }
  
  /*retorna o valor do atributo peso*/
  float getPeso(){
      return peso;
  }
  
  /*Grava o valor recebibo no atributo peso, apenas se o mesmo 
   * estiver entre 0 e 300
   */
  void setPeso( float peso ){
      if (peso > 0.0f && peso < 300.0f ){
          this.peso = peso;
      }
  }
  
  /*Retorna o valor do atributo altura*/
  float getAltura(){
      return altura;
  }
  
  /*Se o valor recebido for maior que 0 e menor que 2,8 grava o mesmo no 
   * atributo altura
   */
  void setAltura( float altura ){
      if ( altura > 0 && altura < 2.8 ) {
          this.altura = altura;
      }
  }
  
  /*Este construtor recebe os valores e os coloca nos atributos
   * nome, idade, peso e altura
   * para ele ser utilizado é obrigatorio que os 4 atributos sejam 
   * informados na ordem descrita acima
   */
  Pessoas(String nome, int idade, float peso, float altura){
      setNome( nome );
      setIdade( idade );
      setPeso( peso );
      setAltura( altura );
  }
  
  /*Este construtor não recebe nenhum dos atributos, ele pede
   * para o usuario digitar valores para cada um deles
   */
  Pessoas(){ 
      Scanner teclado = new Scanner(System.in); 
      System.out.print( "Digite o nome: ");
      nome = teclado.nextLine();
      
      /*chamo os metodos estaticos para a digitacao dos valores inteiros e float
       * enviando os textos que devem ser exbidos
       */
      idade = Funcoes.digitaInt("Digite a idade: ", "Digite uma idade válida!");
      altura = Funcoes.digitaFloat("Digite a altura: ", "Digite uma altura válida!");
      peso = Funcoes.digitaFloat("Digite o peso: ", "Digite um peso válido!");
    }
    
  /*Este metodo calcula e retorna o valor do IMC da pessoa
   * utilizando os atributos peso e altura para fazer o calculo
   */
  float imc(){
    return peso / (altura * altura);
  }
  
  
  /*Metodo utilizado para retornar uma frase sobre o peso 
   * da pessoa, ele calcula o IMC e checa em qual faixa
   * de peso o valor esta
   */
  String situacaoIMC(){
        float valorIMC = imc(); //Chama o metodo IMC e guarda o valor em uma variavel
        
        /*Inicio a variavel texto vazia e nos if abaixo testo os valores para selecionar
         * o texto correto
         */
        String texto = "";
        if ( valorIMC <= 18.5f ) {
            texto = "Abaixo do peso ideal";
        }
        else if ( valorIMC <= 24.9f ) {
            texto = "Peso normal";
        }
        else if ( valorIMC <= 29.9f ) {
            texto = "Acima do peso";
        }
        else if ( valorIMC <= 34.9f ) {
            texto = "Obesidade grau I";
        }        
        else if ( valorIMC <= 39.9f ) {
            texto = "Obesidade grau II";
        }   
        else {
           texto = "Obesidade grau III";
        }   
        return texto; /*retorna a variavel onde foi colocado o texto correto*/
  }
  
  /*Substitiu (override) o metodo toString para que 
   * ele retorne o valor dos atributos e o IMC da pessoa
   */
  public String toString(){
      String texto = "\nNome: " + getNome();
      texto += "\nIdade: " + getIdade();
      texto += "\nPeso: " + getPeso();
      texto += "\nAltura: " + getAltura();
      texto += "\nIMC: " + imc() + " - " +situacaoIMC();     
      return texto;
  }
  

}
