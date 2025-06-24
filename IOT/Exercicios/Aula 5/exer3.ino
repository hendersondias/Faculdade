int buzzer = 8;
int pot = A0;
int frequencia;

void setup() {
  pinMode(buzzer, OUTPUT);
}

void loop() {
  frequencia = map(analogRead(pot), 0, 1023, 100, 2000); // Mapeia o valor do potenciômetro para a frequência
  tone(buzzer, frequencia);
  delay(10);
}
