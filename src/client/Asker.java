package client;

import common.*;

public class Asker {
    private final ConsoleReader console;

    public Asker(ConsoleReader console) {
        this.console = console;
    }


    public String readName() {
        while (true) {
            String input = console.readLine("Введите название города: ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("Название не может быть пустым!");
                continue;
            }
            return input;
        }
    }


    public Coordinates readCoordinates() {
        int x;
        while (true) {
            String input = console.readLine("Введите координату X (целое число): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("X не может быть пустым!");
                continue;
            }
            try {
                x = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }

        float y;
        while (true) {
            String input = console.readLine("Введите координату Y (число ≤ 709): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("Y не может быть пустым!");
                continue;
            }
            try {
                y = Float.parseFloat(input);
                if (y > 709f) {
                    System.out.println("Y должен быть не больше 709!");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
            }
        }
        return new Coordinates(x, y);
    }


    public Double readArea() {
        while (true) {
            String input = console.readLine("Введите площадь (число > 0): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("Площадь не может быть пустой!");
                continue;
            }
            try {
                double val = Double.parseDouble(input);
                if (val <= 0) {
                    System.out.println("Площадь должна быть положительной!");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите число!");
            }
        }
    }

    public Integer readPopulation() {
        while (true) {
            String input = console.readLine("Введите население (целое число > 0): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("Население не может быть пустым!");
                continue;
            }
            try {
                int val = Integer.parseInt(input);
                if (val <= 0) {
                    System.out.println("Население должно быть положительным!");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число!");
            }
        }
    }


    public float readMetersAboveSeaLevel() {
        while (true) {
            String input = console.readLine("Введите высоту над уровнем моря (число): ");
            if (input == null) continue;
            input=input.trim();
            if (input.isEmpty()){
                System.out.println("Высота не может быть пустой!");
            }
            try {
                return Float.parseFloat(input);
            } catch (NumberFormatException e){
                System.out.println("Введите число!");
            }
        }

    }


    public Climate readClimate() {
        System.out.println("Доступные значения Climate:");
        for (Climate c : Climate.values()) {
            System.out.println("  - " + c.name());
        }
        while (true) {
            String input = console.readLine("Введите climate (или пустую строку для null): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                return null;
            }
            try {
                return Climate.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Нет такого значения! Попробуйте снова.");
            }
        }
    }


    public Government readGovernment() {
        System.out.println("Доступные значения Government:");
        for (Government g : Government.values()) {
            System.out.println("  - " + g.name());
        }
        while (true) {
            String input = console.readLine("Введите government (или пустую строку для null): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                return null;
            }
            try {
                return Government.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Нет такого значения! Попробуйте снова.");
            }
        }
    }


    public StandardOfLiving readStandardOfLiving() {
        System.out.println("Доступные значения StandardOfLiving:");
        for (StandardOfLiving s : StandardOfLiving.values()) {
            System.out.println("  - " + s.name());
        }
        while (true) {
            String input = console.readLine("Введите standardOfLiving: ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                System.out.println("Поле не может быть пустым!");
                continue;
            }
            try {
                return StandardOfLiving.valueOf(input.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Нет такого значения! Попробуйте снова.");
            }
        }
    }


    public Human readGovernor() {
        Long height = null;
        System.out.println("Введите рост губернатора (целое число >0, или пустую строку для null): ");
        while (true) {
            String input = console.readLine("");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                break;
            }
            try {
                long val = Long.parseLong(input);
                if (val <= 0) {
                    System.out.println("Рост должен быть положительным! Повторите ввод:");
                    continue;
                }
                height = val;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или оставьте пустую строку.");
            }
        }
        return new Human(height);
    }


    public City readCity() {
        City city = new City();
        city.setName(readName());
        city.setCoordinates(readCoordinates());
        city.setArea(readArea());
        city.setPopulation(readPopulation());
        city.setMetersAboveSeaLevel(readMetersAboveSeaLevel());
        city.setClimate(readClimate());
        city.setGovernment(readGovernment());
        city.setStandardOfLiving(readStandardOfLiving());
        city.setGovernor(readGovernor());
        return city;
    }
}