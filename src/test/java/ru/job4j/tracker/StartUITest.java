package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenCreateItem() {
        Input input = new MockInput(new String[]{"0", "Item name", "1"});
        Tracker tracker = new Tracker();
        StubOutput output = new StubOutput();
        UserAction[] actions = {new CreateAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(output.toString()).contains("Добавленная заявка: Item name");
        assertThat(tracker.findAll()).hasSize(1);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Old name"));
        String[] answers = {"0", String.valueOf(item.getId()), "New name", "1"};
        Input input = new MockInput(answers);
        UserAction[] actions = {new ReplaceAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo("New name");
        assertThat(output.toString()).contains("Заявка изменена успешно.");
    }

    @Test
    void whenDeleteAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Item to delete"));
        String[] answers = {"0", String.valueOf(item.getId()), "1"};
        Input input = new MockInput(answers);
        UserAction[] actions = {new DeleteAction(output), new ExitAction(output)};
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(item.getId())).isNull();
        assertThat(output.toString()).contains("Заявка удалена успешно.");
    }
}