package cs2030.catsanddogs;

public class Dog extends Animal {
    private String _name;
    private int _appetite;
    private String _sound;
    private int _numOfRepetition;

    public Dog(String name, int appetite, String sound) {
        this._name = name;
        this._appetite = appetite;
        this._sound = sound;
        this._numOfRepetition = 0;
    }

    public String getName() {
        return _name;
    };

    public String speak() {
        String output = String.format("%s says %s", _name, _sound);
        for (int i = 0; i < _numOfRepetition; i++)
            output += _sound;
        _numOfRepetition++;
        return output;
    };

    public boolean isHungry() {
        return _appetite > 0;
    };

    public boolean canEat(Food food) {
        if (food instanceof Tuna || food instanceof Cheese) {
            return true;
        }
        return false;
    };

    public String eat(Food food) {
        _appetite--;
        return String.format("%s eats %s", _name, food.toString());
    }

    @Override
    public String toString() {
        return String.format("%s", _name);
    }
}