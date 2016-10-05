package traits

trait FlyingAbility {
    String fly() { "I'm flying" }
}

class Bird implements FlyingAbility {}

Bird b = new Bird()
assert b.fly() == "I'm flying"

