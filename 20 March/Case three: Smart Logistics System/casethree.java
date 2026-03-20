import java.util.*;

abstract class Transport {
    protected String trackingId;
    protected String destination;

    public Transport(String trackingId, String destination) {
        this.destination = destination;
        this.trackingId = trackingId;
    }

    public abstract void dispatch();
}
interface GPS {
    String getCoordinates();

    default void pingServer() {
        System.out.println("Status: Online...");
    }
}
interface Autonomous {
    void selfNavigate();
}

class DeliverDrone extends Transport implements GPS, Autonomous {
    public DeliverDrone(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    public void dispatch() {
        System.out.println("Drone " + trackingId + " taking off...");
    }

    public String getCoordinates() {
        return "40.7128 N";
    }

    public void selfNavigate() {
        System.out.println("Drone navigating automatically...");
    }
}

class Truck extends Transport {

    public Truck(String trackingId, String destination) {
        super(trackingId, destination);
    }

    @Override
    public void dispatch() {
        System.out.println("Truck " + trackingId + " leaving warehouse...");
    }
}

public class casethree {
    public static void main(String[] args) {

        Transport t = new DeliverDrone("D101", "NY");
        t.dispatch();

        GPS g = new DeliverDrone("D101", "NY");
        g.pingServer();

        Transport truck = new Truck("T202", "Chicago");

        if (truck instanceof GPS) {
            GPS gpsTruck = (GPS) truck;
            gpsTruck.getCoordinates();
        } else {
            System.out.println("Truck does not support GPS");
        }
    }
}
