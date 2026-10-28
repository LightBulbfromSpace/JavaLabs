package com.example.universal_project_storage;

public class Main {
    public static void main(String[] args) {
        Storage<String> names = new Storage<>(new String[3]);
        System.out.println("Хранилище строк:");
        System.out.println("Пустое: " + names.isEmpty() + ", размер: " + names.size()
                + ", вместимость: " + names.capacity());
        names.add("Анна");
        names.add("Борис");
        names.add("Вера");
        System.out.println("Элемент с индексом 1: " + names.get(1));
        names.set(1, "Борис обновлён");
        System.out.println("После замены: " + names.get(1));
        System.out.println("Удалён элемент: " + names.remove(0));
        System.out.println("После удаления размер: " + names.size()
                + ", элемент с индексом 0: " + names.get(0));

        try {
            names.add("Глеб");
            names.add("Дарья");
        } catch (IllegalStateException exception) {
            System.out.println("Проверка переполнения: " + exception.getMessage());
        }

        try {
            names.get(names.size());
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Проверка недопустимого индекса: " + exception.getMessage());
        }

        Storage<Integer> numbers = new Storage<>(new Integer[2]);
        System.out.println("\nХранилище целых чисел:");
        numbers.add(10);
        numbers.add(20);
        System.out.println("Элемент с индексом 0: " + numbers.get(0));
        numbers.set(0, 15);
        System.out.println("После замены: " + numbers.get(0));
        System.out.println("Удалён элемент: " + numbers.remove(1));
        System.out.println("Размер: " + numbers.size() + ", вместимость: " + numbers.capacity()
                + ", пустое: " + numbers.isEmpty());
    }
}