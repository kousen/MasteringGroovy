package traits

trait Named {
    String name
}
class NamedPerson implements Named {}
def p = new NamedPerson(name: 'Bob')

assert p.name == 'Bob'
assert p.getName() == 'Bob'