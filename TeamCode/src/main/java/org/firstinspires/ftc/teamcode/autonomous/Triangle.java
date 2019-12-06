package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.autonomous.main.IMUAutonomous;
import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;

@Autonomous(name = "Triangle")
public class Triangle extends IMUAutonomous {

    DriveModule drive;
    double speed = .2;

    @Override
    public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null, null, null);
        return new Stage[] {
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        drive.move(DriveModule.Movement.CCW, .2);
                        return (heading >= 90 && heading <= 110);
                    }
                },
                new Stage() {
                    @Override
                    public boolean run(double h, ElapsedTime time) {
                        drive.move(DriveModule.Movement.CW, speed);
                        return (h <= -180);
                    }
                },
                new Stage() {
                    @Override
                    public boolean run(double h, ElapsedTime time) {
                        drive.move(DriveModule.Movement.CCW, speed);
                        return (h >= 180);
                    }
                },
                new Stage() {
                    @Override
                    public boolean run(double h, ElapsedTime time) {
                        drive.move(DriveModule.Movement.Forward, .4);
                        return (time.seconds() >= 1);
                    }
                }
        };
    }
}
