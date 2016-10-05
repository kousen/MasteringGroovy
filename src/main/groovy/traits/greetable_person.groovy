package traits

trait Greetable {
    abstract String name()
    String greeting() { "Hello, ${name()}!" }
}

class Person implements Greetable {
    String name() { "Bob" }
}

Person p = new Person()
assert p.greeting() == "Hello, Bob!"