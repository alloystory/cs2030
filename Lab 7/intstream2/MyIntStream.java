import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.IntConsumer;

public interface MyIntStream {
    public static MyIntStream of(int... values) {   
        return new MyIntStreamImpl(values);   
    };

    public static MyIntStream range(int start, int end) {   
        if (start > end) {
            return new MyIntStreamImpl(new int[0]);
        } else {
            int size = end - start;
            int[] values = new int[size];
            for (int i = 0; i < size; i++) {
                values[i] = i + start;
            }
            return new MyIntStreamImpl(values);
        }
    };

    public static MyIntStream rangeClosed(int start, int end) {
        return range(start, end + 1);   
    };

    public long count();
    public int sum();
    public OptionalDouble average();
    public OptionalInt max();
    public OptionalInt min();
    public void forEach(IntConsumer action);
}
