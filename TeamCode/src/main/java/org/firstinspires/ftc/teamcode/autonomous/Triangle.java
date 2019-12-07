package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.autonomous.main.IMUAutonomous;
import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;

@Autonomous(name = "Triangle")
public class Triangle extends IMUAutonomous {

    DriveModule drive;
    double speed = .2;

    static final double ALONG_WALL_TIME = 2.5d;

    @Override
    public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null, null, null);
        return new Stage[] {
                new Stage() {
                    @Override
                    public boolean run(double h, ElapsedTime time) {
                        drive.move(DriveModule.Movement.Forward, .2);
                        return (time.milliseconds() > 250);
                    }
                },
                new Stage() {
                    @Override
                    public boolean run(double h, ElapsedTime time) {
                        drive.move(DriveModule.Movement.Left, .2);
                        return time.milliseconds() > ALONG_WALL_TIME;
                    }
                }
        };
    }
}
