package org.firstinspires.ftc.teamcode.autonomous.main;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.autonomous.main.IMUAutonomous;
import org.firstinspires.ftc.teamcode.leelo.modules.ArmModule;
import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HandModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HookModule;
import org.firstinspires.ftc.teamcode.modules.Module;

@Autonomous(name = "Test")
public class AutonomousTestA1 extends IMUAutonomous {
    HandModule grab;
    DriveModule drive;
    HookModule drag;
    double speed = .2;
    double drivetime = .5;
    double strafetime = .25;
    @Override
    //OPEN Hand
    public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null,null, null);
        grab = new HandModule(hardwareMap, gamepad1=null, gamepad2=null, telemetry=null);
        drag = new HookModule(hardwareMap,gamepad1=null, gamepad2=null, telemetry= null);
        return new Stage[] {
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            grab.hand.setPosition(HandModule.OPEN);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //strafe to the right
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < strafetime) {
                            drive.move(DriveModule.Movement.Right, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //close the hand to drop the block
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                          grab.hand.setPosition(HandModule.CLOSED);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //activate the servos to hook on to the platform
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drag.setPosition(HookModule.Position.Down);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //drive backwards to drag the platform
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < .75) {
                            drive.move(DriveModule.Movement.Backward, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //set the servos at its initial position to release the platform
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drag.setPosition(HookModule.Position.Up);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //strafes to the left
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Left, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
                //strafes to the left
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Left, .2);
                            return true;
                        } else {
                            return false;
                        }
                    }
                },
        };
    }
}
