import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Лабораторная работа №14 (Вариант 14: Файловый ввод-вывод) ===");

        if (args.length > 0 && args[0].equals("--all")) {
            runAllTasks(scanner, true);
            return;
        }

        while (true) {
            System.out.println("\nВыберите задание:");
            System.out.println("1 - Задание 1: Файл о любимой еде, свойства файла и чтение");
            System.out.println("2 - Задание 2: 10 целых чисел с клавиатуры в файл, подсчет не кратных 2");
            System.out.println("3 - Задание 3: Случайные числа в файл f, с цифрой 5 в g, остальные в h");
            System.out.println("4 - Задание 4: 15 объёмов жидкости с клавиатуры в файл, средний объём");
            System.out.println("5 - Задание 5: 10 целых чисел в файл f, количество в диапазоне [-50, 50]");
            System.out.println("6 - Выполнить все задания подряд");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            if (!scanner.hasNextLine()) {
                runAllTasks(scanner, true);
                break;
            }

            String choice = scanner.nextLine().trim();
            if (choice.equals("0")) {
                System.out.println("Завершение программы.");
                break;
            }

            switch (choice) {
                case "1":
                    task1();
                    break;
                case "2":
                    task2(scanner, false);
                    break;
                case "3":
                    task3();
                    break;
                case "4":
                    task4(scanner, false);
                    break;
                case "5":
                    task5();
                    break;
                case "6":
                    runAllTasks(scanner, false);
                    break;
                default:
                    System.out.println("Неверный пункт меню, попробуйте снова.");
            }
        }
    }

    private static void runAllTasks(Scanner scanner, boolean useDefaults) {
        System.out.println("\n--- ЗАПУСК ВСЕХ ЗАДАНИЙ ВАРИАНТА 14 ---");
        task1();
        task2(scanner, useDefaults);
        task3();
        task4(scanner, useDefaults);
        task5();
        System.out.println("\n--- ВСЕ ЗАДАНИЯ УСПЕШНО ВЫПОЛНЕНЫ ---");
    }

    public static void task1() {
        System.out.println("\n--- Задание 1. Информация о любимой еде ---");
        File file = new File("favorite_food.txt");
        String content = "Мое любимое блюдо: Пицца Маргарита.\n"
                + "Категория: Итальянская кухня.\n"
                + "Основные ингредиенты:\n"
                + "  1. Пшеничное тесто длительного созревания;\n"
                + "  2. Томатный соус из томатов Сан-Марцано;\n"
                + "  3. Сыр Моцарелла Фиор ди Латте;\n"
                + "  4. Свежие листья зеленого базилика;\n"
                + "  5. Оливковое масло первого холодного отжима (Extra Virgin).\n"
                + "Особенности: Простота, баланс вкусов и хрустящая пышная корочка.";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
            System.out.println("Файл успешно создан и записан: " + file.getName());
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
            return;
        }

        System.out.println("\nДанные о файле:");
        System.out.println("Имя файла: " + file.getName());
        System.out.println("Абсолютный путь: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Существует: " + file.exists());
        System.out.println("Доступен для чтения: " + file.canRead());
        System.out.println("Доступен для записи: " + file.canWrite());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("Время последнего изменения: " + sdf.format(new Date(file.lastModified())));

        System.out.println("\nСодержимое прочитанного файла:");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public static void task2(Scanner scanner, boolean useDefaults) {
        System.out.println("\n--- Задание 2. 10 целых чисел в файл 'f', подсчет не кратных 2 ---");
        File fileF = new File("f_task2.txt");
        List<Integer> inputNumbers = new ArrayList<>();

        if (useDefaults) {
            System.out.println("Используются готовые данные (10 целых чисел): 13, 24, 35, 48, 51, 62, 77, 88, 93, 100");
            int[] demo = {13, 24, 35, 48, 51, 62, 77, 88, 93, 100};
            for (int val : demo) {
                inputNumbers.add(val);
            }
        } else {
            System.out.println("Введите с клавиатуры 10 целых чисел:");
            while (inputNumbers.size() < 10) {
                System.out.printf("Число %d из 10: ", inputNumbers.size() + 1);
                if (!scanner.hasNextInt()) {
                    if (scanner.hasNext()) {
                        String bad = scanner.next();
                        System.out.println("Ошибка: '" + bad + "' не является целым числом. Повторите ввод.");
                        continue;
                    } else {
                        System.out.println("Входной поток завершен, заполнение оставшихся значений автоматически.");
                        while (inputNumbers.size() < 10) {
                            inputNumbers.add((inputNumbers.size() + 1) * 7);
                        }
                        break;
                    }
                }
                inputNumbers.add(scanner.nextInt());
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileF))) {
            for (int n : inputNumbers) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
            System.out.println("Числа успешно записаны в файл '" + fileF.getName() + "'.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            return;
        }

        List<Integer> readNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileF))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    readNumbers.add(Integer.parseInt(line));
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
            return;
        }

        System.out.println("Числа, считанные из файла:");
        int notDivisibleBy2Count = 0;
        for (int num : readNumbers) {
            System.out.print(num + " ");
            if (num % 2 != 0) {
                notDivisibleBy2Count++;
            }
        }
        System.out.println();
        System.out.println("Количество чисел, не кратных 2 (нечетных): " + notDivisibleBy2Count);
    }

    public static void task3() {
        System.out.println("\n--- Задание 3. Случайные числа в файл 'f', с цифрой 5 в 'g', остальные в 'h' ---");
        File fileF = new File("f_task3.txt");
        File fileG = new File("g_task3.txt");
        File fileH = new File("h_task3.txt");

        Random random = new Random();
        int count = 20;
        List<Integer> generated = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            generated.add(random.nextInt(201) - 100);
        }

        try (BufferedWriter writerF = new BufferedWriter(new FileWriter(fileF))) {
            for (int val : generated) {
                writerF.write(Integer.toString(val));
                writerF.newLine();
            }
            System.out.println("Создан файл '" + fileF.getName() + "' с " + count + " случайными числами.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл f: " + e.getMessage());
            return;
        }

        List<Integer> numbersWith5 = new ArrayList<>();
        List<Integer> otherNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileF));
             BufferedWriter writerG = new BufferedWriter(new FileWriter(fileG));
             BufferedWriter writerH = new BufferedWriter(new FileWriter(fileH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                int val = Integer.parseInt(line);
                if (String.valueOf(Math.abs(val)).contains("5")) {
                    numbersWith5.add(val);
                    writerG.write(Integer.toString(val));
                    writerG.newLine();
                } else {
                    otherNumbers.add(val);
                    writerH.write(Integer.toString(val));
                    writerH.newLine();
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при распределении чисел по файлам: " + e.getMessage());
            return;
        }

        System.out.println("Все сгенерированные числа из файла 'f': " + generated);
        System.out.println("Числа с цифрой 5, записанные в файл 'g' (" + numbersWith5.size() + " шт.): " + numbersWith5);
        System.out.println("Остальные числа, записанные в файл 'h' (" + otherNumbers.size() + " шт.): " + otherNumbers);
    }

    public static void task4(Scanner scanner, boolean useDefaults) {
        System.out.println("\n--- Задание 4. 15 вещественных объёмов жидкости, средний объём ---");
        File file = new File("liquid_volumes.txt");
        List<Double> volumes = new ArrayList<>();

        if (useDefaults) {
            System.out.println("Используются готовые данные (15 значений объёма жидкости):");
            double[] demo = {1.5, 2.0, 0.5, 0.75, 5.0, 10.2, 0.33, 1.25, 2.5, 3.0, 0.45, 1.8, 4.5, 6.2, 0.9};
            for (double d : demo) {
                volumes.add(d);
            }
            System.out.println(volumes);
        } else {
            System.out.println("Введите с клавиатуры 15 вещественных значений объёма жидкости (например, 1.5):");
            while (volumes.size() < 15) {
                System.out.printf("Объём %d из 15: ", volumes.size() + 1);
                if (!scanner.hasNextDouble()) {
                    if (scanner.hasNext()) {
                        String token = scanner.next().replace(',', '.');
                        try {
                            volumes.add(Double.parseDouble(token));
                        } catch (NumberFormatException ex) {
                            System.out.println("Ошибка: '" + token + "' не является вещественным числом. Повторите ввод.");
                        }
                    } else {
                        System.out.println("Входной поток завершен, заполнение оставшихся значений автоматически.");
                        while (volumes.size() < 15) {
                            volumes.add(1.0 + volumes.size() * 0.5);
                        }
                        break;
                    }
                } else {
                    volumes.add(scanner.nextDouble());
                }
            }
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (double v : volumes) {
                writer.write(Double.toString(v));
                writer.newLine();
            }
            System.out.println("Значения объёмов успешно сохранены в файл '" + file.getName() + "'.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объёмов: " + e.getMessage());
            return;
        }

        List<Double> readVolumes = new ArrayList<>();
        double sum = 0.0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    double val = Double.parseDouble(line);
                    readVolumes.add(val);
                    sum += val;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении файла объёмов: " + e.getMessage());
            return;
        }

        System.out.println("Считанные значения объёмов: " + readVolumes);
        if (!readVolumes.isEmpty()) {
            double average = sum / readVolumes.size();
            System.out.printf("Количество значений: %d%n", readVolumes.size());
            System.out.printf("Суммарный объём: %.3f%n", sum);
            System.out.printf("Средний объём жидкости: %.4f%n", average);
        }
    }

    public static void task5() {
        System.out.println("\n--- Задание 5. 10 целых чисел в файл 'f', количество в диапазоне [-50, 50] ---");
        File fileF = new File("f_task5.txt");
        int[] numbers = {-75, -50, -25, -3, 0, 14, 49, 50, 68, 120};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileF))) {
            for (int n : numbers) {
                writer.write(Integer.toString(n));
                writer.newLine();
            }
            System.out.println("Файл '" + fileF.getName() + "' успешно создан с 10 числами.");
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла f: " + e.getMessage());
            return;
        }

        List<Integer> readNumbers = new ArrayList<>();
        int inRangeCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileF))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int val = Integer.parseInt(line);
                    readNumbers.add(val);
                    if (val >= -50 && val <= 50) {
                        inRangeCount++;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
            return;
        }

        System.out.println("Числа из файла: " + readNumbers);
        System.out.println("Диапазон проверки: от -50 до 50 включительно");
        System.out.println("Количество чисел, попадающих в диапазон [-50, 50]: " + inRangeCount);
    }
}
