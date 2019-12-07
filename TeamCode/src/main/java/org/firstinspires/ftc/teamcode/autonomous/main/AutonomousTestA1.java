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
    double speed = .25;
    double drivetime = 1.25;
    double strafetime = 1;
    @Override
    //OPEN Hand
    public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null,null, null);
        grab = new HandModule(hardwareMap, null, null, null);
        drag = new HookModule(hardwareMap, null, null, null);
        return new Stage[] {
                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            grab.hand.setPosition(HandModule.CLOSED);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //strafe to the right
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < strafetime) {
                            drive.move(DriveModule.Movement.Right, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //close the hand to drop the block
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                          grab.hand.setPosition(HandModule.OPEN);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //activate the servos to hook on to the platform
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drag.setPosition(HookModule.Position.Down);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //drive backwards to drag the platform
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < .75) {
                            drive.move(DriveModule.Movement.Backward, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //set the servos at its initial position to release the platform
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drag.setPosition(HookModule.Position.Up);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //strafes to the left
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Left, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //drive forward
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Forward, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //strafes to the left
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < drivetime) {
                            drive.move(DriveModule.Movement.Left, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
        };
    }
}
