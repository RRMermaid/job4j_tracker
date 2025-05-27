package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackerTest {

    @Test

    public void whenTestFindById() {
        final Tracker tracker = new Tracker();
        final Item bug = new Item("Bug");
        final Item item = tracker.add(bug);
        final Item result = tracker.findById(item.getId());
        assertThat(result.getName()).isEqualTo(item.getName());
    }

    @Test

    public void whenTestFindAll() {
        final Tracker tracker = new Tracker();
        final Item first = new Item("First");
        final Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        final Item result = tracker.findAll()[0];
        assertThat(result.getName()).isEqualTo(first.getName());
    }

    @Test

    public void whenTestFindByNameCheckArrayLength() {
        final Tracker tracker = new Tracker();
        final Item first = new Item("First");
        final Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        final Item[] result = tracker.findByName(first.getName());
        assertThat(result.length).isEqualTo(3);
    }

    @Test

    public void whenTestFindByNameCheckSecondItemName() {
        final Tracker tracker = new Tracker();
        final Item first = new Item("First");
        final Item second = new Item("Second");
        tracker.add(first);
        tracker.add(second);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("First"));
        final Item[] result = tracker.findByName(second.getName());
        assertThat(result[1].getName()).isEqualTo(second.getName());
    }
}