package org.firstinspires.ftc.teamcode.leelo;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "Test: Motor Tester", group="Test")
public class MotorTester extends OpMode {

    DcMotor fl, fr, rl, rr;

    @Override
    public void init() {
        fl = hardwareMap.dcMotor.get("front_left");
        fr = hardwareMap.dcMotor.get("front_right");
        rl = hardwareMap.dcMotor.get("rear_left");
        rr = hardwareMap.dcMotor.get("rear_right");

        rl.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        fl.setPower(gamepad1.left_trigger);
        fr.setPower(gamepad1.right_trigger);
        rl.setPower(-gamepad1.left_stick_y);
        rr.setPower(-gamepad1.right_stick_y);
    }
}
