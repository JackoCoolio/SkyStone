package org.firstinspires.ftc.teamcode.autonomous.main;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;

@Autonomous(name="ParkFarRight")
public class AutoTestB2 extends AutonomousTestA1 {
    DriveModule drive;
    double speed = .3;

    @Override
    public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null, null, null);
        return new Stage[]{
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < 3) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < 1.25) {
                            drive.move(DriveModule.Movement.Forward, .3);
                            return false;
                        } else {
                            drive.setMotors(0,0,0,0);
                            return true;
                        }
                    }
                },
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < 3) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < .8) {
                            drive.move(DriveModule.Movement.Right, .5);
                            return false;
                        } else {
                            drive.setMotors(0,0,0,0);
                            return true;
                        }
                    }
                }
        };
    }
}
