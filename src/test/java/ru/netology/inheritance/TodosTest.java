package ru.netology.inheritance;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereHaveMatch() { // задачи, в которых есть совпаденния
        SimpleTask simpleTask = new SimpleTask(87, "Приложение Деньги");

        String[] subtasks = {"Ноты", "Барабанные палки"};
        Epic epic = new Epic(68, subtasks);

        Meeting meeting = new Meeting(
                73,
                "Версия 6.1",
                "Приложение Деньги",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("Приложение Деньги");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWhereDoNotHaveMatch() { // нет совпаденний
        SimpleTask simpleTask = new SimpleTask(87, "Установить приложение Деньги");

        String[] subtasks = {"Ноты", "Барабанные палки"};
        Epic epic = new Epic(68, subtasks);

        Meeting meeting = new Meeting(
                73,
                "Версия 6.1",
                "Приложение Здоровье",
                "В понедельник"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Цветы");
        Assertions.assertArrayEquals(expected, actual);
    }
}
