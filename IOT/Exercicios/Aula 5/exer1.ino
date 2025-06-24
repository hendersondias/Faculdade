int led1 = 8;
int led2 = 9;
int led3 = 10;
int pot = A0;
int velocidade;

void setup() {
  pinMode(led1, OUTPUT);
  pinMode(led2, OUTPUT);
  pinMode(led3, OUTPUT);
}

void loop() {
  velocidade = analogRead(pot) / 10;

  digitalWrite(led1, HIGH);
  delay(velocidade);
  digitalWrite(led1, LOW);

  digitalWrite(led2, HIGH);
  delay(velocidade);
  digitalWrite(led2, LOW);

  digitalWrite(led3, HIGH);
  delay(velocidade);
  digitalWrite(led3, LOW);
}
