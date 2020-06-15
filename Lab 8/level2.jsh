/open InfiniteListImpl.java
/open InfiniteList.java

InfiniteList<String> ifl = InfiniteList.generate(() -> "A").map(x -> x + "B");
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()));

InfiniteList<String> ifl = InfiniteList.generate(() -> "A").limit(2);
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()));

InfiniteList<Integer> ifl = InfiniteList.iterate(0, x -> x + 1).filter(x -> x % 2 == 0);
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()));

InfiniteList<Integer> ifl = InfiniteList.iterate(-1, x -> x * -1).takeWhile(x -> x < 0);
IntStream.range(1, 5).forEach(x -> System.out.println(ifl.get()));

/exit