package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                result = i;
                break;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Элемент с именем \"" + key + "\" не найден.");
        }
        return result;
    }

    public static void main(String[] args) {
        String[] data = {"java", "kotlin", "scala"};
        String key = "python";

        try {
            int index = indexOf(data, key);
            System.out.println("Индекс элемента: " + index);
        } catch (ElementNotFoundException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}