void setup() {
  Serial.begin(9600);

}

void loop() {
  double CO2;
  int real_CO2;
  double Temp;
  double CO2_Value=0;
  double Temp_Value=0;

  for(int x=0; x<=100; x++)
  {
    CO2_Value = CO2_Value+analogRead(A0);
  }
  CO2_Value = CO2_Value/100.0;
  CO2= CO2_Value/1024*5.0;
  CO2= (int)((CO2*3000)/3);
  real_CO2=CO2;


  for(int x=0; x<=100; x++)
  {
    Temp_Value = Temp_Value + analogRead(A1);
  }
  Temp_Value = Temp_Value / 100.0;
  Temp = Temp_Value/1024*5.0;
  Temp = (Temp*50)/3;


 // Serial.print("CO2 = ");
  Serial.print(real_CO2);
 // Serial.println("ppm");
 // Serial.print("Temp = ");
 // Serial.print(Temp);
 // Serial.print("C");
 // Serial.print("\n\n");
  delay(2000);
  
  }

