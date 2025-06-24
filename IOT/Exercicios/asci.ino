const int ledPin = 13;

void setup() {

  pinMode(ledPin, OUTPUT);

  Serial.begin(9600);
}

void loop() {
  for (int i = 0; i <= 127; i++) {
    Serial.print(i);
    Serial.print(" - ");
    Serial.println((char)i);

    digitalWrite(ledPin, !digitalRead(ledPin));

    delay(500);
  }
}
