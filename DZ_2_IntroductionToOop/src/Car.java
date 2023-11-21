public class Car {
    private void startElectricity() {
        System.out.println("Starting Electricity");
    }

    private void startCommand() {
        System.out.println("Starting Command");
    }

    private void startFuelSystem() {
        System.out.println("Starting Fuel System");
    }

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }
}
