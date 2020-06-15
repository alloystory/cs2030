// Java Packages
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

// Custom Packages
import cs2030.catsanddogs.Animal;
import cs2030.catsanddogs.Cat;
import cs2030.catsanddogs.Dog;

public class Main {
    // -----------------------------------------------------------------------------------------
    // Main Program
    static BufferedReader scroll = null;
    static TreeSet<Animal> animals = null;

    public static void main(String[] args) {
        try {
            scroll = new BufferedReader(new FileReader(args[0]));
            animals = new TreeSet<>();

            while (scroll.ready()) {
                String instruction = scroll.readLine();
                String[] tokens = instruction.split(" ");
                String operation = tokens[0];
                if (operation.equals("new")) {
                    newOperation(tokens);
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
}