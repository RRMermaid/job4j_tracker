package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old name"));
        String[] answers = {"0", String.valueOf(item.getId()), "New name", "1"};
        Input input = new MockInput(answers);
        UserAction[] actions = {new ReplaceAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("New name");
    }

    @Test
    void whenDeleteAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item to delete"));
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new MockInput(answers);
        UserAction[] actions = {new DeleteAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
    }
}