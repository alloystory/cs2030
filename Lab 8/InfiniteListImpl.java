package cs2030.mystream;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.Optional;

public abstract class InfiniteListImpl<T> implements InfiniteList<T> {
    protected abstract Optional<T> get();

    public <R> InfiniteList<R> map(Function<T, R> mapper) {
        return new InfiniteListImpl<R>() {
            protected Optional<R> get() {
                return InfiniteListImpl.this.get().map(mapper);
            }
        };
    }

    public InfiniteList<T> limit(long maxSize) {
        return new InfiniteListImpl<T>() {
            long remaining = maxSize;

            protected Optional<T> get() {
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
            protected Optional<T> get() {
                Optional<T> element = InfiniteListImpl.this.get();
                while (element.isPresent() && !predicate.test(element.get())) {
                    element = InfiniteListImpl.this.get();
                }
                return element;
            }
        };
    }

    public InfiniteList<T> takeWhile(Predicate<T> predicate) {
        return new InfiniteListImpl<T>() {
            protected Optional<T> get() {
                Optional<T> element = InfiniteListImpl.this.get();
                if (element.isPresent() && !predicate.test(element.get())) {
                    element = Optional.empty();
                }
                return element;
            }
        };
    }

    public long count() {
        long output = 0;
        Optional<T> element = InfiniteListImpl.this.get();
        while (element.isPresent()) {
            output++;
            element = InfiniteListImpl.this.get();
        }
        return output;
    }

    public void forEach(Consumer<T> action) {
        Optional<T> element = InfiniteListImpl.this.get();
        while (element.isPresent()) {
            action.accept(element.get());
            element = InfiniteListImpl.this.get();
        }
    }

    public Optional<T> reduce(BiFunction<T, T, T> accumulator) {
        Optional<T> output = InfiniteListImpl.this.get();
        Optional<T> element = InfiniteListImpl.this.get();
        
        while (output.isPresent() && element.isPresent()) {
            output = Optional.of(accumulator.apply(element.get(), output.get()));
            element = InfiniteListImpl.this.get();
        }
        return output;
    }

    public T reduce(T identity, BiFunction<T, T, T> accumulator) {
        Optional<T> element = InfiniteListImpl.this.get();
        T output = identity;
        while (element.isPresent()) {
            output = accumulator.apply(element.get(), output);
            element = InfiniteListImpl.this.get();
        }
        return output;
    }

    public Object[] toArray() {
        ArrayList<T> output = new ArrayList<T>();
        Optional<T> element = InfiniteListImpl.this.get();
        
        while (element.isPresent()) {
            output.add(element.get());
            element = InfiniteListImpl.this.get();
        }
        return output.toArray();
    }
}