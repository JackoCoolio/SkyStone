package org.firstinspires.ftc.teamcode.leelo.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.typecontainers.MotorConfigurationType;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.Module;

public class DriveModule extends Module {

    DcMotor front_left, front_right, rear_left, rear_right;

    public static final float FAST_SPEED = .8f;
    public static final float SLOW_SPEED = .4f;
    public static final float TURN_MULTIPLIER = 1.0f;

    private float speed = .5f;

    public enum Movement {

        Forward,
        Backward,
        Left,
        Right,
        CW,
        CCW

    }

    public DriveModule(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        super(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init() {
        front_left = hardwareMap.dcMotor.get("front_left");
        front_right = hardwareMap.dcMotor.get("rear_right");
        rear_left = hardwareMap.dcMotor.get("rear_left");
        rear_right = hardwareMap.dcMotor.get("front_right");
        rear_left.setDirection(DcMotorSimple.Direction.REVERSE);

        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rear_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rear_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void move(Movement movement, double speed) {
        switch (movement) {
            case Forward:
                    setMotors(speed,speed,speed,speed);
                break;
            case Backward:
                    setMotors(-speed, -speed, -speed, -speed);
                break;
            case Left:
                    setMotors(speed, -speed, -speed, speed);
                break;
            case Right:
                    setMotors(-speed, speed, speed, -speed);
                break;
            case CW:
                    setMotors(speed, -speed, speed, -speed);
                break;
            case CCW:
                    setMotors(-speed, speed, -speed, speed);
                break;
        }
    }

    public void setMotors(double fl, double fr, double rl, double rr) {
        front_left.setPower(fl);
        front_right.setPower(fr);
        rear_left.setPower(rl);
        rear_right.setPower(rr);
    }

    @Override
    public void loop() {

        if (gamepad1.left_bumper) {
            speed = FAST_SPEED;
        } else {
            speed = SLOW_SPEED;
        }

        double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
        double robotAngle = Math.atan2(- gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x * speed;
        final double v1 = speed*(r * Math.cos(robotAngle) + rightX);
        final double v2 = speed*(r * Math.sin(robotAngle) - rightX);
        final double v3 = speed*(r * Math.sin(robotAngle) + rightX);
        final double v4 = speed*(r * Math.cos(robotAngle) - rightX);

        setMotors(v1, v4, v3, v2);
    }

    @Override
    public void telemetry() {

    }
}
