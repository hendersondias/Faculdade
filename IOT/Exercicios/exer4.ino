int ledPin = 13;
int buttonPin = 2;
bool ledState = true;
bool lastButtonState = HIGH;

void setup() {
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT_PULLUP);
}

void loop() {
  bool buttonState = digitalRead(buttonPin);
  
  if (buttonState == LOW && lastButtonState == HIGH) {
    ledState = !ledState;
    delay(200); 
  }
  lastButtonState = buttonState;
  
  if (ledState) {
    digitalWrite(ledPin, HIGH);
    delay(500);
    digitalWrite(ledPin, LOW);
    delay(500);
  } else {
    digitalWrite(ledPin, LOW);
  }
}
