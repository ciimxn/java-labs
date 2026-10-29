public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №13 (Вариант 14: Транспорт и исключения) ===\n");

        Fleet fleet = new Fleet("Минсктранс Автопарк №1");

        System.out.println("--- 1. Создание корректных объектов транспорта и добавление в автопарк ---");
        try {
            Transport bus = new Transport("Автобус", "МАЗ-203", 2021, 105, 28.5);
            Transport truck = new Transport("Грузовик", "Scania R500", 2019, 24, 31.0);
            Transport van = new Transport("Микроавтобус", "Mercedes-Benz Sprinter", 2022, 19, 11.2);
            Transport oldTruck = new Transport("Грузовик", "ЗИЛ-130", 1968, 6, 35.0);
            Transport defectiveBus = new Transport("Электробус", "БКМ E321", 2023, 85, 18.0);
            defectiveBus.setDefective(true);

            fleet.addTransport(bus);
            fleet.addTransport(truck);
            fleet.addTransport(van);
            fleet.addTransport(oldTruck);
            fleet.addTransport(defectiveBus);

            System.out.println("Успешно добавлено " + fleet.getTransports().size() + " единиц транспорта.");
        } catch (InvalidTransportDataException e) {
            System.out.println("Ошибка при создании транспорта: " + e.getMessage());
        }

        System.out.println("\n--- 2. Обработка InvalidTransportDataException при валидации данных ---");
        try {
            System.out.println("Попытка создать транспорт с годом 1895...");
            new Transport("Паромобиль", "Cugnot", 1895, 4, 50.0);
        } catch (InvalidTransportDataException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            System.out.println("Попытка создать транспорт с вместимостью -5...");
            new Transport("Седан", "Lada", 2020, -5, 8.0);
        } catch (InvalidTransportDataException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            System.out.println("Попытка создать транспорт с отрицательным расходом топлива...");
            new Transport("Фургон", "Ford Transit", 2018, 3, -12.5);
        } catch (InvalidTransportDataException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n--- 3. Расчет топлива методом calculateFuel() ---");
        try {
            Transport scania = fleet.findTransport("Scania R500");
            double distance = 450.0;
            double neededFuel = scania.calculateFuel(distance);
            System.out.printf("Для преодоления %.1f км грузовику %s требуется %.2f л топлива.%n",
                    distance, scania.getBrand(), neededFuel);

            System.out.println("Попытка рассчитать топливо для отрицательной дистанции (-120 км)...");
            scania.calculateFuel(-120.0);
        } catch (TransportNotFoundException | InvalidTransportDataException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n--- 4. Поиск транспорта и обработка TransportNotFoundException ---");
        try {
            System.out.println("Поиск существующего бренда: 'МАЗ-203'...");
            Transport found = fleet.findTransport("МАЗ-203");
            System.out.println("Найден: " + found);

            System.out.println("Поиск несуществующего бренда: 'Tesla Semi'...");
            fleet.findTransport("Tesla Semi");
        } catch (TransportNotFoundException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n--- 5. Выполнение операций обслуживания и обработка MaintenanceException ---");
        try {
            System.out.println("Обслуживание конкретного транспорта: 'Mercedes-Benz Sprinter'...");
            fleet.serviceTransport("Mercedes-Benz Sprinter");
            System.out.println("Обслуживание успешно завершено.");
        } catch (TransportNotFoundException | MaintenanceException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        try {
            System.out.println("Попытка обслуживания транспорта с критической поломкой: 'БКМ E321'...");
            fleet.serviceTransport("БКМ E321");
        } catch (TransportNotFoundException | MaintenanceException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }

        System.out.println("\n--- 6. Массовое обслуживание всего автопарка с обработкой исключений ---");
        fleet.serviceAll();

        System.out.println("\n--- 7. Итоговое состояние автопарка ---");
        fleet.printFleet();
    }
}
