package org.firstinspires.ftc.teamcode.leelo.modules;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.modules.Module;
import org.firstinspires.ftc.teamcode.utility.Button;

public class HandModule extends Module {

    public Servo hand;

    Button handToggle;

    public static final float OPEN = .5f, CLOSED = 1f;

    public HandModule(HardwareMap hardwareMap, Gamepad gamepad1, Gamepad gamepad2, Telemetry telemetry) {
        super(hardwareMap, gamepad1, gamepad2, telemetry);
    }

    @Override
    public void init() {
        hand = hardwareMap.servo.get("hand");
        hand.setDirection(Servo.Direction.REVERSE);
        handToggle = new Button(false);
    }

    @Override
    public void loop() {
        handToggle.update(gamepad1.right_bumper);
        if (handToggle.getState()) {
            hand.setPosition(CLOSED);
        } else {
            hand.setPosition(OPEN);
        }
    }

    @Override
    public void telemetry() {
        telemetry.addData("Hand Position", handToggle.getState()? "closed" : "open");
    }
}
