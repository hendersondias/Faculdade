// Define os pinos
const int LDR_PIN = A0;
const int LED1_PIN = 3;     
const int LED2_PIN = 4;     


const int LIMIAR_ESCURO = 50;  
const int INTERVALO_PISCAR = 500; 


unsigned long ultimaTroca = 0;
bool led1Ativo = false;

void setup() {
  pinMode(LED1_PIN, OUTPUT);
  pinMode(LED2_PIN, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  int valorLDR = analogRead(LDR_PIN); 
  
  valorLDR = map(valorLDR, 0, 1023, 0, 100);
  
  if (valorLDR < LIMIAR_ESCURO) {
    if (millis() - ultimaTroca >= INTERVALO_PISCAR) {
      ultimaTroca = millis();
      led1Ativo = !led1Ativo; 
      
      digitalWrite(LED1_PIN, led1Ativo ? HIGH : LOW);
      digitalWrite(LED2_PIN, led1Ativo ? LOW : HIGH);
    }
  } else {
    
    digitalWrite(LED1_PIN, LOW);
    digitalWrite(LED2_PIN, LOW);
    led1Ativo = false; 
  
  Serial.print("Valor LDR: ");
  Serial.println(valorLDR);
  delay(100); 
}