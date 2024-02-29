package Centerstage;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "EighthGradeDemoArcade") 
public class EighthGradeDemoArcade extends OpMode {

    private DcMotor red;
    private DcMotor blue;
    
    @Override
    public void init() {
        red = hardwareMap.get(DcMotor.class, "red");
		blue = hardwareMap.get(DcMotor.class, "blue");
		blue.setDirection(DcMotor.Direction.REVERSE);
	}

	@Override
    public void loop() {
		telemetry.addData("Left Power", blue.getPower());
		telemetry.addData("Right Power", red.getPower());
		red.setPower(gamepad1.left_stick_y-gamepad1.left_stick_x);
		blue.setPower(gamepad1.left_stick_y+gamepad1.left_stick_x);
//		red is right
//		blue is left
	}

}
