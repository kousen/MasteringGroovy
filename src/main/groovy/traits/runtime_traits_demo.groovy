package traits

trait Extra {
    String extra() { "I'm an extra method" }
}

class Something {
    String doSomething() { 'Something' }
}

def s = new Something() as Extra
assert s.doSomething() == 'Something'
assert s.extra() == "I'm an extra method"

// Implement multiple traits at runtime
trait T1 {
    String t1method() { "t1 method" }
}

trait T2 {
    String t2method() { "t2 method" }
}

class MyClass {}

def myClass = new MyClass()
def myClassWithTraits = myClass.withTraits(T1, T2)

assert myClassWithTraits.t1method() == 't1 method'
assert myClassWithTraits.t2method() == 't2 method'

println myClass.class.name
println myClassWithTraits.class.name