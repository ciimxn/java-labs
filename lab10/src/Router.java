public class Router implements Connectable, Configurable {
    private String model;
    private boolean connected;
    private String settings;

    public Router(String model) {
        this.model = model;
        this.connected = false;
        this.settings = "По умолчанию (DHCP, WPA2)";
    }

    @Override
    public void connect() {
        this.connected = true;
        System.out.println("Роутер [" + model + "] успешно подключен к сети провайдера.");
    }

    @Override
    public void disconnect() {
        this.connected = false;
        System.out.println("Роутер [" + model + "] отключен от сети.");
    }

    @Override
    public boolean isConnected() {
        return connected;
    }

    @Override
    public void configure(String settings) {
        this.settings = settings;
        System.out.println("Роутер [" + model + "] настроен: " + settings);
    }

    @Override
    public void reset() {
        this.settings = "Заводские настройки";
        System.out.println("Роутер [" + model + "] сброшен до заводских настроек.");
    }

    public String getModel() {
        return model;
    }

    public String getSettings() {
        return settings;
    }

    @Override
    public String toString() {
        return String.format("Роутер: %-15s | Подключение: %-5s | Настройки: %s",
                model, (connected ? "ВКЛ" : "ВЫКЛ"), settings);
    }
}
