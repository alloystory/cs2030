import java.util.function.Supplier;
import java.util.function.Function;

public interface InfiniteList<T> {
    public T get();
    
    public static <T> InfiniteList<T> generate(Supplier<T> supplier) {
        return new InfiniteList<T>() {
            public T get() {
                return supplier.get();
            }
        };
    }

    public static <T> InfiniteList<T> iterate(T seed, Function<T, T> next) {
        return new InfiniteList<T>() {
            T element = seed;
            Function<T, T> func = new Function<T, T>() {
                public T apply(T arg) {
                    func = next;
                    return element;
                }
            };

            public T get() {
                element = func.apply(element);
                return element;
            }
        };
    }
}
