// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {

// Spark Max Code, established CanID from Constant and Type of Motor)
  CANSparkMax LeftFront = new CANSparkMax(Constants.DriveTrainConstants.LeftFrontCANID, 
  CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax LeftBack = new CANSparkMax(Constants.DriveTrainConstants.LeftBackCANID, 
  CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax RightFront = new CANSparkMax(Constants.DriveTrainConstants.RightFrontANID, 
  CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax RightBack = new CANSparkMax(Constants.DriveTrainConstants.RightBackCANID, 
  CANSparkMaxLowLevel.MotorType.kBrushless);

  //
  RelativeEncoder leftEncoder = LeftFront.getEncoder();
  RelativeEncoder rightEncoder = RightFront.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(LeftBack, LeftFront);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(RightBack, RightFront);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup,rightControllerGroup);



  public DriveTrainSubsystem() {
  //
  LeftFront.restoreFactoryDefaults();
  LeftBack.restoreFactoryDefaults();
  RightFront.restoreFactoryDefaults();
  RightBack.restoreFactoryDefaults();
  //
  leftEncoder.setPosition(0);
  rightEncoder.setPosition(0);

  //
  LeftBack.follow(LeftFront);
  RightBack.follow(RightFront);

  }
}
