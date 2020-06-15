package cs2030.catsanddogs;

public abstract class Animal implements Comparable<Animal> {
    protected abstract String getName();

    @Override
    public int compareTo(Animal other) {
        return this.getName().compareTo(other.getName());
    }
}