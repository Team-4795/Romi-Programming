// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.Drivebase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class TriangleDrive extends SequentialCommandGroup {
  /** Creates a new TriangleDrive. */
  public TriangleDrive(Drivebase drivebase) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(0.5, 4, drivebase),
      new TurnAngle(120, 0.5, drivebase),
      new DriveDistance(0.5, 4, drivebase),
      new TurnAngle(120, 0.5, drivebase));
  }
}
