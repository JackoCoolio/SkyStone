package org.firstinspires.ftc.teamcode.autonomous.main;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HandModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HookModule;

@Autonomous(name = "TestB1")
public class AutonomousTestB1 extends IMUAutonomous {
    HandModule grab;
    DriveModule drive;
    HookModule drag;
    double speed = .25;
    double drivetime = 1.5;
    double strafetime = 1;
    @Override
        public Stage[] setStages() {
        drive = new DriveModule(hardwareMap, null,null, null);
        grab = new HandModule(hardwareMap, null, null, null);
        drag = new HookModule(hardwareMap, null, null, null);
        return new Stage[] {
                //Close the hand
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
                        if (runtime.seconds() < 1.5) {
                            drive.move(DriveModule.Movement.Forward, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //strafe to the left
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < 1.3) {
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
                        if (runtime.seconds() < 1) {
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
                        if (runtime.seconds() < 2) {
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
                        if (runtime.seconds() < 2) {
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
                        if (runtime.seconds() < 2) {
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
                        if (runtime.seconds() < 2) {
                            drag.setPosition(HookModule.Position.Up);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
                //strafes to the right
                new Stage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < 1.5) {
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
                        if (runtime.seconds() < 1.5) {
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
                        if (runtime.seconds() < 2.2) {
                            drive.move(DriveModule.Movement.Right, speed);
                            return false;
                        } else {
                            return true;
                        }
                    }
                },
        };
    }
}
