package frc.robot.commands;


import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Drivebase;
public class ConstantSpeed extends CommandBase {

    
    private final PIDController controller = new PIDController(0.03, 0.00, 0.0);

    private Drivebase m_drivebase;

    public ConstantSpeed(Drivebase drivebase) {
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivebase);
        m_drivebase = drivebase;
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {}

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = 15;
        double feedforward = speed * 0.03 + 0.0533;
        double output = controller.calculate(m_drivebase.getLeftSpeed(), speed) + feedforward;
        SmartDashboard.putNumber("Speed Controller output", output);
        
        m_drivebase.tankDrive(output, 0);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
