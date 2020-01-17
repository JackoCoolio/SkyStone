package org.firstinspires.ftc.teamcode.utility;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.modules.ModularOpMode;

@TeleOp(name = "vuforia test man")
public class VuforiaPhoneTest extends ModularOpMode {
    @Override
    public void initModules() {
        registerModules(VuforiaModule.class);
    }
}
