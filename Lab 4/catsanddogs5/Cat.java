package cs2030.catsanddogs;

public class Cat extends Animal {
    private String _name;
    private int _appetite;
    private String _sound;
    private String _colour;
    private boolean _isLazy;

    public Cat(String name, int appetite, String colour) {
        this._name = name;
        this._appetite = appetite;
        this._colour = colour;
        this._sound = "meow";
        this._isLazy = false;
    }

    protected String getName() {
        return _name;
    };

    public String speak() {
        String output;
        if (_isLazy) {
            output = String.format("%s(%s) is lazy", _name, _colour);
        } else {
            output = String.format("%s(%s) says %s and gets lazy", _name, _colour, _sound);
        }
        _isLazy = !_isLazy;
        return output;
    };

    public boolean isHungry() {
        return _appetite > 0;
    };

    public boolean canEat(Food food) {
        if (food instanceof Tuna || food instanceof Chocolate) {
            return true;
        }
        return false;
    };

    public String eat(Food food) {
        _appetite--;
        return String.format("%s(%s) eats %s", _name, _colour, food.toString());
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", _name, _colour);
    }
}