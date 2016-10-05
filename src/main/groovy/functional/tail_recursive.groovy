package functional

import groovy.transform.*
import static java.math.BigInteger.*

@TailRecursive
def fact(n, acc = ONE) {
    n < 2 ? acc : fact(n - ONE, n * acc)
}

def result = fact(70000)
println "$result".size() // 308,760 digits