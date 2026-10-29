public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №11 (Вариант 14: Полиморфизм - Здания) ===\n");

        Building simpleBuilding = new Building("ул. Ленина, 10", 3, 450.0);
        Residential residential = new Residential("пр. Независимости, 45", 9, 3600.0, 72);
        Office office = new Office("ул. Немига, 5", 16, 8200.0, "EPAM Systems");

        System.out.println("--- 1. Демонстрация ПЕРЕГРУЗКИ методов (Method Overloading) ---");
        simpleBuilding.build();
        simpleBuilding.build(5);
        simpleBuilding.build("монолитного железобетона и кирпича");

        System.out.println("\n--- 2. Демонстрация ПЕРЕОПРЕДЕЛЕНИЯ методов (Method Overriding) ---");
        Building[] cityBuildings = new Building[] {
            simpleBuilding,
            residential,
            office,
            new Residential("ул. Притыцкого, 102", 19, 9500.0, 150),
            new Office("пр. Победителей, 20", 25, 14000.0, "Wargaming")
        };

        System.out.println("Список зданий города (динамический полиморфизм getPurpose):");
        for (Building b : cityBuildings) {
            System.out.println(b);
        }
    }
}
