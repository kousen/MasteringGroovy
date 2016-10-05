package traits

trait Flying {
    String fly() { "I'm flying!" }
}
trait Speaking {
    String speak() { "I'm speaking!" }
}

class Duck implements Flying, Speaking {}

def d = new Duck()
assert d.fly() == "I'm flying!"
assert d.speak() == "I'm speaking!"