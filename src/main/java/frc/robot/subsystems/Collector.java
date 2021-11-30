package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;


import java.util.function.BooleanSupplier;

public class Collector extends SubsystemBase {

    public void collect(final double speed){

        leftCollector.set(speed);
        rightCollector.set(-speed);

    }
    public void spool(final double spoolSpeed){

        spoolMotor.set(spoolSpeed);

    }
}
