package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {

    private final Item[] items = new Item[100];

    private int ids = 1;

    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            final Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        final Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items[index].getName().equals(key)) {
                result[count++] = items[index];
            }
        }
        return Arrays.copyOf(result, count);
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                item.setId(id);
                items[index] = item;
                result = true;
                break;
            }
        }
        return result;
    }
}