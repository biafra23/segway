import lejos.nxt.*;
import lejos.nxt.addon.GyroSensor;
import lejos.robotics.navigation.*;

public class SegBumper {

  public static int speed = 0;
  public static int statis = 0;

  public static void main(String[] args) throws Exception {

    GyroSensor g = new GyroSensor(SensorPort.S1);

    NXTMotor left = new NXTMotor(MotorPort.B);
    NXTMotor right = new NXTMotor(MotorPort.C);

    UltrasonicSensor us = new UltrasonicSensor(SensorPort.S4);

    Segway robot = new Segway(left, right, g, SegwayPilot.WHEEL_SIZE_NXT2);

    Thread.sleep(250000);

    robot.wheelDriver(-120, -120);


    while(!Button.ESCAPE.isPressed()) {

      if (us.getDistance() < 40) {

        robot.wheelDriver(120, 60);
        Thread.sleep(2000);
        robot.wheelDriver(-120, -120);

      }

      Thread.sleep(350);


    }
  }
}
