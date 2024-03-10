package ru.netology.inheritance;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void testingQueryInSimpleTask() { // тест на запрос данных из SimpleTask

        SimpleTask simpleTask = new SimpleTask(89, "Выполнить тестовое задание");

        Assertions.assertEquals(89, simpleTask.getId());
        Assertions.assertEquals("Выполнить тестовое задание", simpleTask.getTitle());
    }

    @Test
    public void testingQueryInEpic() { // тест на запрос данных из Epic
        String[] subtasks = {"Гуашь", "Альбом для рисования", "Кисточки"};
        Epic epic = new Epic(34, subtasks);

        Assertions.assertEquals(34, epic.getId());
        String[] expected = {"Гуашь", "Альбом для рисования", "Кисточки"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testingQueryInMeeting() { // тест на запрос данных из Meeting
        Meeting meeting = new Meeting(
                22,
                "Новый маршрут",
                "Маршрут автобуса №39",
                "31 марта 2024 года"
        );

        Assertions.assertEquals(22, meeting.getId());
        Assertions.assertEquals("Новый маршрут", meeting.getTopic());
        Assertions.assertEquals("Маршрут автобуса №39", meeting.getProject());
        Assertions.assertEquals("31 марта 2024 года", meeting.getStart());
    }

    @Test
    public void testSimpleTasksMatches() { // тест на совпадения в SimpleTask
        SimpleTask simpleTask = new SimpleTask(7,"Помыть машину");

        Assertions.assertEquals(true, simpleTask.matches("машину")); //есть совпадения в title
        Assertions.assertEquals(false, simpleTask.matches("посуду")); //нет совпадений в title
    }

    @Test
    public void testEpicMatches() { // тест на совпадения в Epic
        String[] subtasks = {"Ноты", "Гуашь", "Цветы"};
        Epic epic = new Epic(33, subtasks);

        Assertions.assertEquals(true, epic.matches("Цветы")); //есть совпадения в subtasks
        Assertions.assertEquals(false, epic.matches("Автомобиль")); //нет совпадений в subtasks
    }

    @Test
    public void testMeetingMatches() { //проверяет совпадения в Meeting
        Meeting meeting = new Meeting(44,
                "Тест-драйв автомобиля",
                "Автосалон",
                "22 октября");

        Assertions.assertEquals(true, meeting.matches("автомобиля")); //есть совпадение в topic
        Assertions.assertEquals(true, meeting.matches("Автосалон")); //есть совпадение в project
        Assertions.assertEquals(false, meeting.matches("Гуашь")); //нет совпадений

    }

    @Test
    public void testTaskMatches() {
        Task task = new Task(17);

        Assertions.assertEquals(false, task.matches("25"));
    }
}
