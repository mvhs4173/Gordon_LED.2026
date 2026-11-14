// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.AddressableLEDBufferView;
import edu.wpi.first.wpilibj.LEDPattern;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Leds extends SubsystemBase {
  private AddressableLED m_AddressableLED;
  private AddressableLEDBuffer m_AddressableLEDBuffer;
  private int m_length;
  private int m_pwmPort;
  private AddressableLEDBufferView m_warningView;
  private AddressableLEDBufferView m_speedView;
  /** Creates a new Leds. */
  public Leds() {

   m_pwmPort = 6;
   m_length = 40;
   m_AddressableLED = new AddressableLED(m_pwmPort);
   m_AddressableLED.setLength(m_length);
   m_AddressableLEDBuffer = new AddressableLEDBuffer(m_length);
   m_warningView = m_AddressableLEDBuffer.createView(0,3);
   LEDPattern red = LEDPattern.solid(Color.kRed);
   red.applyTo(m_AddressableLEDBuffer);
   m_AddressableLED.setData(m_AddressableLEDBuffer); 
  
  
   m_AddressableLED.setData(m_AddressableLEDBuffer);
   m_AddressableLED.start();
  }

  public void setWarningColor(Color color){
    LEDPattern pattern = LEDPattern.solid(color);
    pattern.applyTo(m_warningView);
  }
  public Command setWarningRed(){
    return run(() -> setWarningColor(Color.kDarkBlue));
  }
   public Command setWarningGreen(){
    return run(() -> setWarningColor(Color.kDarkGreen));
   }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_AddressableLED.setData(m_AddressableLEDBuffer);
  }
}
