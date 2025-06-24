int segundo = 0, minuto = 0, hora = 0;
unsigned long utempo = 0;
unsigned long tempo;


const int botaoHora = 2;
const int botaoMinuto = 3;
const int botaoSegundo = 4;

void setup() {
  Serial.begin(9600);
  
  pinMode(botaoHora, INPUT_PULLUP);
  pinMode(botaoMinuto, INPUT_PULLUP);
  pinMode(botaoSegundo, INPUT_PULLUP);
}

void loop() { 
  tempo = millis(); 
  
  verificaBotoes();
  
  if (tempo - utempo >= 1000) {
    utempo = tempo;
    segundo++;
    
    if (segundo >= 60) {
      segundo = 0; 
      minuto++;
    }
    if (minuto >= 60) { 
      minuto = 0;
      hora++;
    }
    if (hora >= 24) {
      hora = 0;
    }
    
    imprimeHorario();
  }
}

void verificaBotoes() {
  if (digitalRead(botaoHora) == LOW) {
    hora++;
    if (hora >= 24) hora = 0;
    imprimeHorario();
    delay(300); 
    while(digitalRead(botaoHora) == LOW);
  }

  if (digitalRead(botaoMinuto) == LOW) {
    minuto++;
    if (minuto >= 60) minuto = 0;
    imprimeHorario();
    delay(300); 
    while(digitalRead(botaoMinuto) == LOW); 
  }
  
  if (digitalRead(botaoSegundo) == LOW) {
    segundo++;
    if (segundo >= 60) segundo = 0;
    imprimeHorario();
    delay(300);
    while(digitalRead(botaoSegundo) == LOW);
  }
}

void imprimeHorario() {
  if (hora < 10) Serial.print("0");
  Serial.print(hora);
  Serial.print(":");
  
  if (minuto < 10) Serial.print("0");
  Serial.print(minuto);
  Serial.print(":");
  
  if (segundo < 10) Serial.print("0");
  Serial.println(segundo);
}