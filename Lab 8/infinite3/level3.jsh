/open InfiniteList.java
/open InfiniteListImpl.java

InfiniteList.iterate(1, x -> x + 1).map(x -> x + 1).limit(5).forEach(System.out::println)
Stream.iterate(1, x -> x + 1).map(x -> x + 1).limit(5).forEach(System.out::println)

InfiniteList.iterate(1, x -> x + 1).filter(x -> x % 3 == 0).limit(5).forEach(System.out::println)
Stream.iterate(1, x -> x + 1).filter(x -> x % 3 == 0).limit(5).forEach(System.out::println)

InfiniteList.iterate(1, x -> x + 1).takeWhile(x -> x < 3).limit(5).forEach(System.out::println)
Stream.iterate(1, x -> x + 1).takeWhile(x -> x < 3).limit(5).forEach(System.out::println)

InfiniteList.iterate(1, x -> x + 1).takeWhile(x -> x < 3).limit(5).reduce((x, y)-> x+y)

/exit
