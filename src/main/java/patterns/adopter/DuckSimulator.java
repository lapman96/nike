package patterns.adopter;

public class DuckSimulator {
    static void testDuck(Duck duck){
        duck.quack();
        duck.fly();
    }

    public static void main(String[] args) {
        Drone drone = new Drone();
        DroneAdapter droneAdapter = new DroneAdapter(drone);
        testDuck(droneAdapter);
    }
}
