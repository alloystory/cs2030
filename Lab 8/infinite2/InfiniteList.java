import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;

public interface InfiniteList<T> {
    public Optional<T> get();
    
    public static <T> InfiniteList<T> generate(Supplier<T> supplier) {
        return new InfiniteListImpl<T>() {
            public Optional<T> get() {
                return Optional.of(supplier.get());
            }
        };
    }

    public static <T> InfiniteList<T> iterate(T seed, Function<T, T> next) {
        return new InfiniteListImpl<T>() {
            T element = seed;
            Function<T, T> func = new Function<T, T>() {
                public T apply(T arg) {
                    func = next;
                    return element;
                }
            };

            public Optional<T> get() {
                element = func.apply(element);
                return Optional.of(element);
            }
        };
    }

    public <R> InfiniteList<R> map(Function<T, R> mapper);
    public InfiniteList<T> limit(long maxSize);
    public InfiniteList<T> filter(Predicate<T> predicate);
    public InfiniteList<T> takeWhile(Predicate<T> predicate);
}
