// Java Packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.ArrayList;

// Custom Packages
import cs2030.catsanddogs.Animal;
import cs2030.catsanddogs.Cat;
import cs2030.catsanddogs.Dog;
import cs2030.catsanddogs.Food;
import cs2030.catsanddogs.Tuna;
import cs2030.catsanddogs.Cheese;
import cs2030.catsanddogs.Chocolate;

public class Main {
    // -----------------------------------------------------------------------------------------
    // Main Program
    static BufferedReader scroll = null;
    static TreeSet<Animal> animals = null;
    static ArrayList<Food> food = null;

    public static void main(String[] args) {
        try {
            scroll = new BufferedReader(new FileReader(args[0]));
            animals = new TreeSet<>();
            food = new ArrayList<>();

            while (scroll.ready()) {
                String instruction = scroll.readLine();
                String[] tokens = instruction.split(" ");
                String operation = tokens[0];
                if (operation.equals("new")) {
                    newOperation(tokens);
                } else if (operation.equals("add")) {
                    addOperation(tokens);
                } else if (operation.equals("eat")) {
                    eatOperation();
                } else if (operation.equals("hello")) {
                    helloOperation();
                }
            }

            scroll.close();
        }
        catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }

    // -----------------------------------------------------------------------------------------
    // Operations
    public static void newOperation(String[] tokens) {
        String type = tokens[1];
        String name = tokens[2];
        int appetite = Integer.parseInt(tokens[3]);

        Animal animal = null;
        if (type.equals("cat")) {
            String colour = tokens[4];
            animal = new Cat(name, appetite, colour);
            animals.add(animal);
        } else if (type.equals("dog")) {
            String sound = tokens[4];
            animal = new Dog(name, appetite, sound);
            animals.add(animal);
        }
        System.out.println(animal + " was created");
    }

    public static void addOperation(String[] tokens) {
        String type = tokens[1];
        String brand = tokens[2];

        Food item = null;
        if (type.equals("tuna")) {
            item = new Tuna(brand);
            food.add(item);
        } else if (type.equals("cheese")) {
            item = new Cheese(brand);
            food.add(item);
        } else if (type.equals("chocolate")) {
            String flavour = tokens[3];
            item = new Chocolate(brand, flavour);
            food.add(item);
        }
        System.out.println(item + " was added");
    }

    public static void eatOperation() {
        for (Animal animal : animals) {
            int foodIndex = 0;
            while (animal.isHungry()) {
                if (foodIndex >= food.size())
                    break;
                Food item = food.get(foodIndex);
                if (animal.canEat(item)) {
                    System.out.println(animal.eat(item));
                    food.remove(foodIndex);
                } else {
                    foodIndex++;
                }
            }
        }
    }

    public static void helloOperation() {
        for (Animal animal : animals) {
            System.out.println(animal.speak());
        }
    }
}