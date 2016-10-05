package functional

import java.util.stream.Stream

[3, 1, 4, 1, 5, 9].stream()
    .map { it * 2 }
    .filter { it % 3 == 0 }
    .forEach { println it }

println Stream.generate( Math.&random )
    .limit(1000)
    .mapToInt { (int) (it * 100) }
    .filter { it % 3 == 0 }
    .summaryStatistics()