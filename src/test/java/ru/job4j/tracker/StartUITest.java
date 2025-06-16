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

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Редактирование заявки ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("First item"));
        Item item2 = tracker.add(new Item("Second item"));
        Input input = new MockInput(new String[] {"0", "1"});
        UserAction[] actions = {
                new FindAllAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Список всех заявок ===" + ln
                        + item1 + ln
                        + item2 + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Fix bug"));
        Input input = new MockInput(new String[] {"0", "Fix bug", "1"});
        UserAction[] actions = {
                new FindByNameAction(output),
                new ExitAction(output)
        };

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявок по имени ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Найти заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdActionFound() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Fix bug"));
        Input input = new MockInput(new String[] {"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {
                new FindByIdAction(output),
                new ExitAction(output)
        };

        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Поиск заявки по id ===" + ln
                        + item + ln
                        + "Меню:" + ln
                        + "0. Найти заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "=== Завершение программы ===" + ln
        );
    }
}