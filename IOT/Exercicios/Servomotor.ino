#include <Servo.h>

Servo meuServo;
int angulo = 90; // posição inicial do servo

void setup() {
  meuServo.attach(9); // pino conectado ao sinal do servo
  meuServo.write(angulo);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available() > 0) {
    char comando = Serial.read();

    if (comando == 'A') {
      angulo += 15;
      if (angulo > 180) {
        angulo = 180;
      }
      meuServo.write(angulo);
    } 
    else if (comando == 'B') {
      angulo -= 15;
      if (angulo < 0) {
        angulo = 0;
      }
      meuServo.write(angulo);
    }
  }
}
