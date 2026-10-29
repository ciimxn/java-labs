public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №10 (Вариант 14: Интерфейсы Connectable и Configurable) ===\n");

        Router[] routers = new Router[] {
            new Router("TP-Link Archer AX73"),
            new Router("Keenetic Giga KN-1011")
        };

        Computer[] computers = new Computer[] {
            new Computer("MacBook Pro 16", "macOS Sonoma"),
            new Computer("ASUS ROG Strix", "Windows 11 Pro"),
            new Computer("ThinkPad X1", "Ubuntu 22.04 LTS")
        };

        System.out.println("--- Начальное состояние устройств ---");
        for (Router r : routers) System.out.println(r);
        for (Computer c : computers) System.out.println(c);

        System.out.println("\n--- Настройка и подключение роутеров ---");
        routers[0].configure("SSID: Home_5G, Pass: secret123, IP: 192.168.1.1");
        routers[0].connect();
        routers[1].connect();

        System.out.println("\n--- Подключение компьютеров к сети ---");
        for (Computer c : computers) {
            c.connect();
        }

        System.out.println("\n--- Использование полиморфизма интерфейсов (Connectable[]) ---");
        Connectable[] networkDevices = new Connectable[] {
            routers[0],
            routers[1],
            computers[0],
            computers[1],
            computers[2]
        };

        System.out.println("Статус всех сетевых устройств:");
        for (int i = 0; i < networkDevices.length; i++) {
            System.out.printf("[%d] %-25s -> В сети: %b%n",
                    i + 1, networkDevices[i].getClass().getSimpleName(), networkDevices[i].isConnected());
        }

        System.out.println("\n--- Отключение и сброс одного устройства ---");
        routers[1].reset();
        routers[1].disconnect();
        System.out.println(routers[1]);
    }
}
