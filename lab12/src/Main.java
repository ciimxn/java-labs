import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Лабораторная работа №12 (Вариант 14) ===\n");

        System.out.println("--- Задание 1. Коллекция Map<String, Garment> ---");
        Map<String, Garment> garmentMap = new LinkedHashMap<>();

        Jacket jacket1 = new Jacket("Кожаная куртка Biker", 101, "L", "Натуральная кожа");
        Jacket jacket2 = new Jacket("Зимний пуховик Arctic", 102, "XL", "Мембрана / пух");
        Jacket jacket3 = new Jacket("Ветровка SportLite", 103, "M", "Полиэстер");

        TShirt tshirt1 = new TShirt("Футболка Oversize Black", 201, "L", "Minimalist Logo");
        TShirt tshirt2 = new TShirt("Футболка Vintage Band", 202, "M", "Rock Legend");
        TShirt tshirt3 = new TShirt("Футболка Classic White", 203, "S", "Plain Simple");

        Pants pants1 = new Pants("Джинсы Slim Denim", 301, "32", 105);
        Pants pants2 = new Pants("Брюки Chino Casual", 302, "34", 108);

        garmentMap.put(jacket1.getName(), jacket1);
        garmentMap.put(jacket2.getName(), jacket2);
        garmentMap.put(jacket3.getName(), jacket3);

        garmentMap.put(tshirt1.getName(), tshirt1);
        garmentMap.put(tshirt2.getName(), tshirt2);
        garmentMap.put(tshirt3.getName(), tshirt3);

        garmentMap.put(pants1.getName(), pants1);
        garmentMap.put(pants2.getName(), pants2);

        System.out.println("Список элементов в карте (всего " + garmentMap.size() + "):");
        for (Map.Entry<String, Garment> entry : garmentMap.entrySet()) {
            System.out.println("Ключ: \"" + entry.getKey() + "\" -> Значение: " + entry.getValue());
        }

        System.out.println("\n--- Задание 2. Коллекция List<Programmer> ---");
        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer(1, "Алексей Смирнов", "Java", 2, Arrays.asList(5, 5, 4, 5)));
        programmers.add(new Programmer(2, "Дмитрий Мельник", "Java", 3, Arrays.asList(4, 5, 4, 4)));
        programmers.add(new Programmer(3, "Екатерина Иванова", "Python", 1, Arrays.asList(2, 2, 3, 2)));
        programmers.add(new Programmer(4, "Михаил Козлов", "C++", 2, Arrays.asList(1, 2, 2, 3)));
        programmers.add(new Programmer(5, "Ольга Сидорова", "Kotlin", 2, Arrays.asList(4, 4, 4, 4)));
        programmers.add(new Programmer(6, "Анна Кузнецова", "TypeScript", 3, Arrays.asList(5, 5, 5, 5)));
        programmers.add(new Programmer(7, "Сергей Попов", "Go", 1, Arrays.asList(3, 3, 4, 3)));

        System.out.println("Исходный список программистов:");
        for (Programmer p : programmers) {
            System.out.println(p);
        }

        System.out.println("\nОперация 1. Удаление программистов со средним рейтингом < 3");
        programmers.removeIf(p -> p.getAverageReview() < 3.0);
        for (Programmer p : programmers) {
            System.out.println(p);
        }

        System.out.println("\nОперация 2. Повышение уровня программистов со средним рейтингом >= 4");
        for (Programmer p : programmers) {
            if (p.getAverageReview() >= 4.0) {
                p.setLevel(p.getLevel() + 1);
            }
        }
        for (Programmer p : programmers) {
            System.out.println(p);
        }

        System.out.println("\nОперация 3. Печать программистов с уровнем 3:");
        printProgrammers(programmers, 3);

        System.out.println("\nОперация 4. Упорядочивание по убыванию среднего рейтинга (при совпадении - по имени):");
        programmers.sort(Comparator.comparingDouble(Programmer::getAverageReview).reversed()
                .thenComparing(Programmer::getName));

        for (Programmer p : programmers) {
            System.out.printf("ID: %-3d | Имя: %-20s | Средний рейтинг: %.2f%n",
                    p.getId(), p.getName(), p.getAverageReview());
        }
    }

    public static void printProgrammers(List<Programmer> programmers, int level) {
        boolean found = false;
        for (Programmer p : programmers) {
            if (p.getLevel() == level) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Программистов на уровне " + level + " не найдено.");
        }
    }
}
