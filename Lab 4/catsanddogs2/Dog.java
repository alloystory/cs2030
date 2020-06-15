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

    @Override
    public String toString() {
        return String.format("%s", _name);
    }
}