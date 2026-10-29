import java.util.ArrayList;
import java.util.List;

public class Fleet {
    private String name;
    private final List<Transport> transports;

    public Fleet(String name) {
        this.name = name;
        this.transports = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addTransport(Transport transport) {
        if (transport != null) {
            transports.add(transport);
        }
    }

    public List<Transport> getTransports() {
        return new ArrayList<>(transports);
    }

    public Transport findTransport(String brand) throws TransportNotFoundException {
        if (brand == null || brand.trim().isEmpty()) {
            throw new TransportNotFoundException("Поисковый запрос бренда не может быть пустым.");
        }
        for (Transport t : transports) {
            if (t.getBrand().equalsIgnoreCase(brand.trim())) {
                return t;
            }
        }
        throw new TransportNotFoundException("Транспортное средство с брендом '" + brand + "' не найдено в автопарке \"" + name + "\".");
    }

    public void serviceTransport(String brand) throws TransportNotFoundException, MaintenanceException {
        Transport t = findTransport(brand);
        t.service();
    }

    public void serviceAll() {
        System.out.println("Запуск планового техобслуживания для автопарка \"" + name + "\":");
        int successCount = 0;
        int failureCount = 0;
        for (Transport t : transports) {
            try {
                t.service();
                System.out.println("  [УСПЕХ] Обслужен: " + t.getBrand() + " (" + t.getType() + ")");
                successCount++;
            } catch (MaintenanceException e) {
                System.out.println("  [СБОЙ] " + e.getMessage());
                failureCount++;
            }
        }
        System.out.printf("Итоги обслуживания автопарка: успешно %d, ошибок %d%n", successCount, failureCount);
    }

    public void printFleet() {
        System.out.println("Состав автопарка \"" + name + "\" (всего " + transports.size() + " ед.):");
        for (int i = 0; i < transports.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + transports.get(i));
        }
    }
}
