// Pinos BCD compartilhados
const int BCD_A = 2;
const int BCD_B = 3;
const int BCD_C = 4;
const int BCD_D = 5;

// Pinos LE dos dois CD4511 (usados como "seletores")
const int LE1 = 6; // Unidade
const int LE2 = 7; // Dezena

void setup() {
  // Configurar pinos como saída
  for (int pin = 2; pin <= 7; pin++) {
    pinMode(pin, OUTPUT);
  }

  // Garantir que tudo comece em LOW
  for (int pin = 2; pin <= 7; pin++) {
    digitalWrite(pin, LOW);
  }
}

void mostrarNumero(int numero, int LE) {
  int unidadesBCD = numero & 0x0F; // Máscara dos 4 bits

  // Colocar LE em LOW antes de mudar os bits
  digitalWrite(LE, LOW);

  // Mandar bits BCD para os pinos
  digitalWrite(BCD_A, bitRead(unidadesBCD, 0));
  digitalWrite(BCD_B, bitRead(unidadesBCD, 1));
  digitalWrite(BCD_C, bitRead(unidadesBCD, 2));
  digitalWrite(BCD_D, bitRead(unidadesBCD, 3));

  // Ativar LE (o CD4511 irá armazenar o valor)
  digitalWrite(LE, HIGH);
}

void loop() {
  for (int i = 0; i <= 99; i++) {
    int unidade = i % 10;
    int dezena = i / 10;

    // Mostrar dígitos
    mostrarNumero(unidade, LE1); // Unidade
    mostrarNumero(dezena, LE2);  // Dezena

    delay(1000); // Esperar 1 segundo
  }
}
