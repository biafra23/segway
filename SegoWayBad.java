import lejos.nxt.*;
import lejos.nxt.addon.GyroSensor;

public class SegoWayBad {

  public static int speed = 0;
  public static int statis = 0;

  public static void main(String[] args) throws Exception {

    GyroSensor s = new GyroSensor(SensorPort.S1);
    Motor.B.flt();

    Thread.sleep(1000);
    statis = (int)s.getAngularVelocity();

    for(int i = 0; i < 5; i++) {

      Sound.beep();
      Thread.sleep(1000);
    }

    while(!Button.ESCAPE.isPressed()) {

      int aVelocity = (int) s.getAngularVelocity();

      int diff = aVelocity - statis;
        
      speed = Math.abs(diff) * 30;

      Motor.B.setSpeed(speed);
      Motor.A.setSpeed(speed);

      boolean forward = diff > 0;

      if (forward) {

        Motor.B.forward();
        Motor.C.forward();

      } else  {

        Motor.B.backward();
        Motor.C.backward();

      }

      Thread.sleep(8);


    }
    Motor.B.flt();
    Motor.C.flt();
  }
}
