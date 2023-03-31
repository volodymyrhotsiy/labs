package ua.lviv.iot.algo.part1.laba1;

import java.util.Comparator;
import java.util.List;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class TransportManager {
    private ArrayList<Transport> transports;

    public TransportManager() {
        this.transports = new ArrayList<Transport>();
    }

    public void addTransport(Transport transport) {
        transports.add(transport);
    }

    public List<Transport> findAllTransportsWithMaxSpeedGraterThen(int speed) {
        List<Transport> filteredTransports = this.transports.stream()
                .filter(transport -> transport.getMaxSpeed() > speed)
                .collect(Collectors.toList());
        return filteredTransports;
    }

    public List<Transport> sortTransportsPlatesAlphabetically() {
        List<Transport> filteredTransports = this.transports.stream()
                .sorted(Comparator.comparing(transport ->
                        transport.getPlateNumber() == null ? "" : transport.getPlateNumber()))
                .collect(Collectors.toList());
        return filteredTransports;
    }


    public static void main(String[] args) {
        TransportManager transportManager = new TransportManager();
        transportManager.addTransport(new Trolleybus());
        transportManager.addTransport(new Trolleybus(112, 60, "FVH 562", 22, "stop1", 30, 40, 12));
        transportManager.addTransport(new Car());
        transportManager.addTransport(new Car(113, 120, "KPL 947", 4, 30, 10));
        transportManager.addTransport(new Motorcycle());
        transportManager.addTransport(new Motorcycle(114, 150, "JXG 309", 50, true, "red", 200));
        transportManager.addTransport(new Bike());
        transportManager.addTransport(new Bike(115, 30, "NCB 815", 20, 20, 6, "red", false));
        transportManager.transports.forEach(System.out::println);
        System.out.println(transportManager.findAllTransportsWithMaxSpeedGraterThen(50));
        System.out.println(transportManager.sortTransportsPlatesAlphabetically());
    }
}
