package client;

import common.City;
import java.util.Vector;

public class TempClient {
    public static void main(String[] args) {
        ConsoleReader console = new ConsoleReader();
        Asker asker = new Asker(console);
        CommandHistory history = new CommandHistory();

        Vector<City> tempCollection = new Vector<>();

        System.out.println("=== Тестовый клиент с JLine ===");
        System.out.println("Команды: add, show, history, exit (работают стрелки и Tab)");

        while (true) {
            String input = console.readLine("> ");
            input = input.trim();
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+", 2);
            String command = parts[0];
            history.addCommand(command);

            switch (command) {
                case "add":
                    City city = asker.readCity();
                    tempCollection.add(city);
                    System.out.println("✅ Город добавлен! Всего: " + tempCollection.size());
                    break;
                case "show":
                    if (tempCollection.isEmpty()) System.out.println("Коллекция пуста.");
                    else tempCollection.forEach(c -> System.out.println(c));
                    break;
                case "history":
                    history.printHistory();
                    break;
                case "exit":
                    System.out.println("Выход.");
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }
}