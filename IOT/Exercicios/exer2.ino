const int ledPin = 13;

void setup() {
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  static int elefantes = 1; 
  
  Serial.print(elefantes);
  if (elefantes == 1) {
    Serial.println(" elefante incomoda muita gente!");

    digitalWrite(ledPin, HIGH);
    delay(500);
    digitalWrite(ledPin, LOW);
    delay(500);
  } else {
    Serial.print(" elefantes incomodam");

    for (int i = 0; i < elefantes; i++) {
      Serial.print(" incomodam");

      digitalWrite(ledPin, HIGH);
      delay(500);
      digitalWrite(ledPin, LOW);
      delay(500);
    }

    Serial.println(" muito mais!");
  }

  elefantes++;

  delay(1000);
}
