package org.firstinspires.ftc.teamcode.leelo.modules;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.Module;

public class ArmModule extends Module {

    DcMotor arm0, arm1;

    final float arm0speed = 1;
    final float arm1speed = 1;

    public ArmModule(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        super(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init() {
        arm0 = hardwareMap.dcMotor.get("arm0");
        arm1 = hardwareMap.dcMotor.get("arm1");
    }

    @Override
    public void loop() {
        if (gamepad1.a) {
            arm0.setPower(-arm0speed);
        } else if (gamepad1.b) {
            arm0.setPower(arm0speed);
        } else
            arm0.setPower(0);

        if (gamepad1.x) {
            arm1.setPower(-arm1speed);
        } else if (gamepad1.y) {
            arm1.setPower(arm1speed);
        } else
            arm1.setPower(0);
    }

    @Override
    public void telemetry() {
        telemetry.addData("Arm 0", arm0.getPower());
        telemetry.addData("Arm 1", arm1.getPower());
    }
}
