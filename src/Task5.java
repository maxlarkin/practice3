import java.util.Scanner;
import java.util.Arrays;

public class Task5 {
    private static int[][] dataStorage = new int[3][];

    private static Scanner scanner = new Scanner(System.in);
    private static boolean isRunning = true;

    public static void main(String[] args) {
        displayWelcome();

        while (isRunning) {
            displayMainMenu();
            processUserChoice();
        }
    }

    private static void displayWelcome() {
        System.out.println("ДОБРО ПОЖАЛОВАТЬ В ПРОГРАММУ ПУЗЫРЬКОВОЙ СОРТИРОВКИ");
    }

    private static void displayMainMenu() {
        System.out.println("ОПЦИИ");
        System.out.println("0 - Выйти из программы");
        System.out.println("1 - Ввести массив и отсортировать его");
        System.out.println("2 - Информация о программе");
        System.out.println("3 - Информация об авторе");
        System.out.print("Выберите опцию (0-3) >> ");
    }

    private static void processUserChoice() {
        try {
            int choice = readIntInput();

            switch (choice) {
                case 0:
                    isRunning = false;
                    break;
                case 1:
                    handleSortingProcess();
                    break;
                case 2:
                    displayProgramInfo();
                    break;
                case 3:
                    displayAuthorInfo();
                    break;
                default:
                    System.out.println("Ошибка: введите число от 0 до 3!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Некорректный ввод. Введите целое число.");
        }
    }

    private static int readIntInput() throws NumberFormatException {
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            throw new NumberFormatException("Пустой ввод");
        }
        return Integer.parseInt(input);
    }

    private static void handleSortingProcess() {
        try {
            inputArray();
            calculateSortedArray();
            outputResults();
        } catch (Exception e) {
            System.out.println("Ошибка при обработке массива: " + e.getMessage());
        }
    }

    private static void inputArray() {
        System.out.println("Введите массив целых чисел через пробел: ");
        String input = scanner.nextLine();
        int[] array = Arrays.stream(input.split(" "))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        dataStorage[0] = array;
    }

    private static void calculateSortedArray() {
        if (dataStorage[0] == null || dataStorage[0].length == 0) {
            throw new IllegalArgumentException("Массив не инициализирован");
        }

        int[] sourceArray = dataStorage[0];
        int[] sortedArray = sourceArray.clone();

        int n = sortedArray.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray[j] > sortedArray[j + 1]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j + 1];
                    sortedArray[j + 1] = temp;
                }
            }
        }

        dataStorage[1] = sortedArray;
    }

    private static void outputResults() {
        System.out.print("Исходный массив: ");
        displayArray(dataStorage[0]);

        System.out.print("Отсортированный массив: ");
        displayArray(dataStorage[1]);
    }

    private static void displayArray(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("[ пусто ]");
            return;
        }
        System.out.println(Arrays.toString(array));
    }

    private static void displayProgramInfo() {
        System.out.println("ИНФОРМАЦИЯ О ПРОГРАММЕ");
        System.out.println("Программа реализует алгоритм пузырьковой сортировки (Bubble Sort)");
        System.out.println("для сортировки массивов целых чисел в порядке возрастания.");
    }

    private static void displayAuthorInfo() {
        System.out.println("ИНФОРМАЦИЯ ОБ АВТОРЕ");
        System.out.println("Автор: ученик РИ-250911 ИРИТ-РТФ в УрФУ");
    }
}