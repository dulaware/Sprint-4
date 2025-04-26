package model;
import manager.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task("Переезд", "Организовать переезд", manager.generateId(), Status.NEW);
        Task task2 = new Task("Покупка техники", "Купить холодильник", manager.generateId(), Status.IN_PROGRESS);
        manager.createTask(task1);
        manager.createTask(task2);

        Epic epic1 = new Epic("Организация дня рождения", "Подготовка к празднику", manager.generateId());
        Epic epic2 = new Epic("Покупка квартиры", "Покупка недвижимости", manager.generateId());
        manager.createEpic(epic1);
        manager.createEpic(epic2);

        Subtask sub1 = new Subtask("Купить торт", "Выбрать и купить торт", manager.generateId(), Status.NEW, epic1.getId());
        Subtask sub2 = new Subtask("Позвать гостей", "Отправить приглашения", manager.generateId(), Status.NEW, epic1.getId());
        Subtask sub3 = new Subtask("Выбрать риелтора", "Найти надёжного агента", manager.generateId(), Status.IN_PROGRESS, epic2.getId());
        manager.createSubtask(sub1);
        manager.createSubtask(sub2);
        manager.createSubtask(sub3);

        System.out.println("\nВсе задачи:");
        manager.getAllTasks().forEach(System.out::println);

        System.out.println("\nВсе эпики:");
        manager.getAllEpics().forEach(System.out::println);

        System.out.println("\nВсе подзадачи:");
        manager.getAllSubtasks().forEach(System.out::println);

        System.out.println("\nОбновим статус подзадач и выведем эпики:");
        sub1.setStatus(Status.DONE);
        sub2.setStatus(Status.DONE);
        manager.updateSubtask(sub1);
        manager.updateSubtask(sub2);
        manager.getAllEpics().forEach(System.out::println);

        System.out.println("\nУдалим одну задачу и один эпик:");
        manager.deleteTaskById(task1.getId());
        manager.deleteEpicById(epic2.getId());

        System.out.println("\nИтоговый список задач:");
        manager.getAllTasks().forEach(System.out::println);
        System.out.println("\nИтоговый список эпиков:");
        manager.getAllEpics().forEach(System.out::println);
        System.out.println("\nИтоговый список подзадач:");
        manager.getAllSubtasks().forEach(System.out::println);


    }
}