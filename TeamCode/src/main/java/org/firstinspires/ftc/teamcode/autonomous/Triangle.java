package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.autonomous.main.IMUAutonomous;

@Autonomous(name = "Triangle")
public class Triangle extends IMUAutonomous {

    @Override
    public Stage[] setStages() {
        return new Stage[] {
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        return false;
                    }
                }
        };
    }
}
