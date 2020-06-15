import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Optional;

public abstract class InfiniteListImpl<T> implements InfiniteList<T>{
    public <R> InfiniteList<R> map(Function<T, R> mapper) {
        return new InfiniteListImpl<R>() {
            public Optional<R> get() {
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    }

    public InfiniteList<T> limit(long maxSize) {
        return new InfiniteListImpl<T>() {
            long remaining = maxSize;

            public Optional<T> get() {
                if (remaining == 0) {
                    return Optional.empty();
                } else if (remaining > 0) {
                    remaining -= 1;
                    return InfiniteListImpl.this.get();
                } else {
                    throw new IllegalArgumentException("Max Value must be a non-negative integer");
                }
            }
        };
    }

    public InfiniteList<T> filter(Predicate<T> predicate) {
        return new InfiniteListImpl<T>() {
            public Optional<T> get() {
                Optional<T> element = InfiniteListImpl.this.get();
                if (!element.isPresent()) {
                    return Optional.empty();
                } else {
                    while(!predicate.test(element.get())) {
                        element = InfiniteListImpl.this.get();
                    }
                    return element;
                }
            }
        };
    }

    public InfiniteList<T> takeWhile(Predicate<T> predicate) {
        return new InfiniteListImpl<T>() {
            boolean stopped = false;

            public Optional<T> get() {
                Optional<T> element = InfiniteListImpl.this.get();
                if (stopped || element.isPresent() && !predicate.test(element.get())) {
                    stopped = true;
                    element = Optional.empty();
                }
                return element;
            }
        };
    }
}