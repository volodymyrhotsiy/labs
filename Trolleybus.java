package ua.lviv.iot.algo.part1.laba1;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Trolleybus {
    private int id = 100;
    private int routeNumber;
    private String currentStop;
    private int maxSpeed;
    private int speed;
    private int capacity;
    private int passengers;
    private static Trolleybus instance;

    public static void main(String ... args) {

        Trolleybus bus1 = new Trolleybus();
        Trolleybus bus2 = new Trolleybus(101,22,"Stop N34",60,30,20,5);
        Trolleybus bus3 = Trolleybus.getInstance();
        Trolleybus bus4 = Trolleybus.getInstance();
        Trolleybus[] trolleybuses = {bus1,bus2,bus3,bus4};
    }
    public static Trolleybus getInstance() {
        if (instance == null) {
            instance = new Trolleybus();
        }
        return instance;
    }

    public void stop() {
        System.out.println("Stopped at " + currentStop);
        speed = 0;
    }
    public void start() {
        speed = 20;
    }

    public void addPassenger(String passenger) {
        if (passengers < capacity) {
            passengers++;
        } else {
            System.out.println("Bus is full");
        }
    }
    public void removePassenger(String passenger) {
        if (passengers > 0) {
            passengers--;
        } else {
            System.out.println("Bus is empty");
        }
    }
}
