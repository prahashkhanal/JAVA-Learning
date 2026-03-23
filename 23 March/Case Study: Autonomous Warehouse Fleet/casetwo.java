import java.util.*;

abstract class Robot {
    private String batteryId;
    protected double chargeLevel;

    public Robot(String batteryId, double chargeLevel) {
        this.batteryId = batteryId;
        this.chargeLevel = chargeLevel;
    }

    public String getBatteryId() {
        return batteryId;
    }

    public void reportStatus() {
        System.out.println("Robot ID: " + batteryId + ", Charge: " + chargeLevel + "%");
    }

    public abstract void performTask();
}

class DroneRobot extends Robot {
    public DroneRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    @Override
    public void performTask() {
        if (chargeLevel < 15 ) {
            System.out.println("Low Battery!");
            return;
        }
        chargeLevel -= 15;
        System.out.println("Drone completed task at 2x speed.");
    }
}

class GroundRobot extends Robot {
    public GroundRobot(String batteryId, double chargeLevel) {
        super(batteryId, chargeLevel);
    }

    @Override
    public void performTask() {
        if (chargeLevel < 5) {
            System.out.println("Low Battery!");
            return;
        }

        System.out.println("Performing surface check");
        chargeLevel -= 5;
        System.out.println("Ground Robot completed task.");
    }
}

public class casetwo {
    public static void main(String[] args) {
        Robot[] fleet = {
                new DroneRobot("D-1", 20),
                new GroundRobot("D-5", 10),
                new DroneRobot("D-2", 10)
        };
        for (Robot r : fleet) {
            r.performTask();
            r.reportStatus();
            System.out.println("--------------------------");
        }
    }
}