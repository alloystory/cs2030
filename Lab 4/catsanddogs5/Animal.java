package cs2030.catsanddogs;

public abstract class Animal implements Comparable<Animal> {
    protected abstract String getName();
    public abstract String speak();
    public abstract boolean isHungry();
    public abstract boolean canEat(Food food);
    public abstract String eat(Food food);

    @Override
    public int compareTo(Animal other) {
        return this.getName().compareTo(other.getName());
    }
}