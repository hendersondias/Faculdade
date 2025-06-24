// Pinos do sensor
const int trigPin = 9;
const int echoPin = 10;

// Pino do buzzer
const int buzzerPin = 8;

// Variáveis para cálculo de distância
long duration;
int distance;

void setup() {
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(buzzerPin, OUTPUT);

  Serial.begin(9600); // (opcional) para debug via monitor serial
}

void loop() {
  // Enviar pulso de trigger
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);

  // Ler tempo de resposta (echo)
  duration = pulseIn(echoPin, HIGH);

  // Calcular distância em cm
  distance = duration * 0.034 / 2;

  Serial.print("Distância: ");
  Serial.print(distance);
  Serial.println(" cm");

  // Verificar distância e ativar buzzer
  if (distance > 0 && distance < 5) {
    digitalWrite(buzzerPin, HIGH); // Ativa alarme
  } else {
    digitalWrite(buzzerPin, LOW);  // Desliga alarme
  }

  delay(200); // Leitura a cada 200ms
}
