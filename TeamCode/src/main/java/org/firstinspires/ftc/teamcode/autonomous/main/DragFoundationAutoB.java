package org.firstinspires.ftc.teamcode.autonomous.main;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.leelo.modules.DriveModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HandModule;
import org.firstinspires.ftc.teamcode.leelo.modules.HookModule;

@Autonomous(name = "Drag Foundation Blue")
public class DragFoundationAutoB extends IMUAutonomous {

    private static float diagonalTime = 1f;
    private static float diagonalSpeed = .5f;

    private static float forwardTime = 2f;
    private static float forwardSpeed = .2f;

    private static float dockTime = 1f;
    private static float dockSpeed = .1f;

    private static float hookTime = 2.5f;

    private static float pullTime = 2.5f;
    private static float pullSpeed = .35f;

    private static float alignSpeed = .3f;
    private static float alignThreshold = 3f;
    private static float alignTarget = 1f;

    private static float lineTime = 2f;
    private static float lineSpeed = .5f;

    @Override
    public Stage[] setStages() {

        final DriveModule drive = new DriveModule(hardwareMap, null, null, telemetry);
        final HookModule hook = new HookModule(hardwareMap, null, null, telemetry);
        final HandModule hand = new HandModule(hardwareMap, null, null, telemetry);

        resetHeadingEveryStage(false);

        return new Stage[]{
                new Stage() {

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {

                        hook.setPosition(HookModule.Position.Up);
                        hand.setPosition(HandModule.Position.OPEN);

                        if (runtime.seconds() < diagonalTime) {
                            drive.setMotors(0, diagonalSpeed, diagonalSpeed, 0);
                        } else {
                            drive.setMotors(0, 0, 0, 0);
                            return true;
                        }

                        return false;

                    }

                },
                new Stage() {

                    @Override
                    public void setup(double heading, ElapsedTime runtime) {
                        runtime.reset();
                    }

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {

                        if (runtime.seconds() < forwardTime) {
                            drive.setMotors(forwardSpeed, forwardSpeed, forwardSpeed, forwardSpeed);
                        } else {
                            drive.setMotors(0, 0, 0, 0);
                            return true;
                        }

                        return false;

                    }
                },
                new StagePresets.ResetTimeStage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < dockTime) {
                            drive.move(DriveModule.Movement.Forward, dockSpeed);
                            return false;
                        } else {
                            drive.setMotors(0, 0, 0, 0);
                            return true;
                        }
                    }
                },
//                new StagePresets.ResetTimeStage() {
//                    @Override
//                    public boolean run(double heading, ElapsedTime runtime) {
//                        return (runtime.seconds() < 10f);
//                    }
//                },
                new Stage() {

                    @Override
                    public void setup(double heading, ElapsedTime runtime) {
                        runtime.reset();
                    }

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {

                        hook.setPosition(HookModule.Position.Down);
                        return (runtime.seconds() > hookTime);

                    }
                },
                new Stage() {

                    @Override
                    public void setup(double heading, ElapsedTime runtime) {
                        runtime.reset();
                    }

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {

                        if (runtime.seconds() < pullTime) {
                            drive.setMotors(-pullSpeed, -pullSpeed, -pullSpeed, -pullSpeed);
                        } else {
                            drive.setMotors(0, 0, 0, 0);
                            return true;
                        }

                        return false;

                    }
                },
                new StagePresets.ResetTimeStage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {

                        hook.setPosition(HookModule.Position.Up);
                        return runtime.seconds() > hookTime;

                    }
                },

                new StagePresets.ResetTimeStage() {
                    @Override
                    public void setup(double heading, ElapsedTime runtime) {runtime.reset();}

                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (runtime.seconds() < lineTime) {
                            drive.move(DriveModule.Movement.Right, lineSpeed);
                            return false;
                        } else {
                            drive.setMotors(0,0,0,0);
                            return true;
                        }
                    }
                },



/*                new Stage() {
                    @Override
                    public boolean run(double heading, ElapsedTime runtime) {
                        if (Math.abs(heading) > 1f)
                        {
                            if (heading < 1)
                                drive.move(DriveModule.Movement.CCW, alignSpeed);
                            else if (heading > 1)
                                drive.move(DriveModule.Movement.CW, alignSpeed);
                            return false;
                        } else {
                            drive.setMotors(0,0,0,0);
                            return true;
                        }
                    }
                },*/
                /*    new Stage() {

                        boolean aligning = true;
                        float alignStartTime = 0f;
                        float addAlignTime = 0f;

                        @Override public void setup(double heading, ElapsedTime runtime) { runtime.reset(); }

                        @Override
                        public boolean run(double heading, ElapsedTime runtime) {

                            if (aligning) {

                                if (heading > alignTarget) {
                                    drive.move(DriveModule.Movement.CW, .5 * alignSpeed);
                                } else if (heading < alignTarget) {
                                    drive.move(DriveModule.Movement.CCW, .5 * alignSpeed);
                                } else {
                                    aligning = false;
                                    addAlignTime += runtime.seconds() - alignStartTime;
                                }
                            } else {
                                if (Math.abs(heading) > alignThreshold) {
                                    aligning = true;
                                    alignStartTime = (float) runtime.seconds();
                                } else {
                                    drive.move(DriveModule.Movement.Left, lineSpeed);
                                }
                            }

                            if (runtime.seconds() >= lineTime + addAlignTime) {
                                drive.setMotors(0,0,0,0);
                                return true;
                            }

                            return false;

                        }
                    }*/
        };
    }
}
