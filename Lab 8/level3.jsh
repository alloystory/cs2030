/open InfiniteList.java
InfiniteList<String> ifl = InfiniteList.generate(() -> "A")
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()))


ifl = InfiniteList.iterate("A", x -> x + "A");
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()))

InfiniteList<String> ifl = InfiniteList.generate(() -> "A").iterate("A", x -> x + "A")
/exit