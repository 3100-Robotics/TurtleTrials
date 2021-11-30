package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Shooter extends SubsystemBase {

    public void shoot(final double leftSpeed, final double rightSpeed){

        leftShooter.set(leftSpeed);
        rightShooter.set(-rightSpeed);

    }
    
}
