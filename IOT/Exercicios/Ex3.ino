int ledPin = 13;
int recebido;

void setup() {
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    recebido = Serial.parseInt();
    
    if (recebido >= 0 && recebido <= 9) {
      Serial.print("Piscar LED ");
      Serial.print(recebido);
      Serial.println(" vezes");
      
      for (int i = 0; i < recebido; i++) {
        digitalWrite(ledPin, HIGH);
        delay(500);
        digitalWrite(ledPin, LOW);
        delay(500);
      }
    } else {
      Serial.println("Número inválido. Digite um número de 0 a 9.");
    }
  }
}
