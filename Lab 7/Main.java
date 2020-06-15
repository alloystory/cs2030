import cs2030.mystream.MyIntStream;

public class Main {
    public static void main(String[] args) {
        MyIntStream input = MyIntStream.rangeClosed(1, 100);
        System.out.println(input);
        System.out.println(input.reduce((x, y) -> y * 2));
    }
}