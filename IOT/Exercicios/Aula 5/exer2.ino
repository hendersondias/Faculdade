int leds[] = {2, 3, 4, 5, 6, 7, 8, 9}; 
int pot = A0;
int velocidade;

void setup() {
  for (int i = 0; i < 8; i++) {
    pinMode(leds[i], OUTPUT);
  }
}

void loop() {
  velocidade = analogRead(pot) / 10;
  
  for (int i = 0; i < 8; i++) {
    digitalWrite(leds[i], HIGH);
    delay(velocidade);
    digitalWrite(leds[i], LOW);
  }
}
