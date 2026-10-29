public class Computer implements Connectable, Configurable {
    private String model;
    private boolean connected;
    private String os;
    private String currentNetwork;

    public Computer(String model, String os) {
        this.model = model;
        this.os = os;
        this.connected = false;
        this.currentNetwork = "Не подключено";
    }

    @Override
    public void connect() {
        this.connected = true;
        this.currentNetwork = "Wi-Fi Сеть (Internet)";
        System.out.println("Компьютер [" + model + "] подключен к интернету.");
    }

    @Override
    public void disconnect() {
        this.connected = false;
        this.currentNetwork = "Не подключено";
        System.out.println("Компьютер [" + model + "] отключен от интернета.");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void configure(String settings) {
        this.os += " (" + settings + ")";
        System.out.println("Компьютер [" + model + "] применил параметры конфигурации: " + settings);
    }

    @Override
    public void reset() {
        this.connected = false;
        this.currentNetwork = "Не подключено";
        System.out.println("Сетевые параметры компьютера [" + model + "] сброшены.");
    }

    public String getModel() {
        return model;
    }

    public String getOs() {
        return os;
    }

    @Override
    public String toString() {
        return String.format("Компьютер: %-15s | ОС: %-15s | Сеть: %s (Подключен: %s)",
                model, os, currentNetwork, (connected ? "Да" : "Нет"));
    }
}
