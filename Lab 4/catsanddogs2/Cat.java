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
    
    @Override
    public String toString() {
        return String.format("%s(%s)", _name, _colour);
    }
}