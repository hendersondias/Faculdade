// Pinos conectados aos segmentos a-g
const int segmentos[7] = {2, 3, 4, 5, 6, 7, 8};

// Tabela de bits para números de 0 a 9
const byte numeros[10][7] = {
  // a b c d e f g
  {1,1,1,1,1,1,0}, // 0
  {0,1,1,0,0,0,0}, // 1
  {1,1,0,1,1,0,1}, // 2
  {1,1,1,1,0,0,1}, // 3
  {0,1,1,0,0,1,1}, // 4
  {1,0,1,1,0,1,1}, // 5
  {1,0,1,1,1,1,1}, // 6
  {1,1,1,0,0,0,0}, // 7
  {1,1,1,1,1,1,1}, // 8
  {1,1,1,1,0,1,1}  // 9
};

void setup() {
  for (int i = 0; i < 7; i++) {
    pinMode(segmentos[i], OUTPUT);
  }
}

void loop() {
  for (int n = 0; n <= 9; n++) {
    mostrarNumero(n);
    delay(1000); // espera 1 segundo
  }
}

void mostrarNumero(int numero) {
  for (int i = 0; i < 7; i++) {
    digitalWrite(segmentos[i], numeros[numero][i]);
  }
}
