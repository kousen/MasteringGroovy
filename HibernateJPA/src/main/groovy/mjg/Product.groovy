package mjg

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.Id

@Canonical @Entity
class Product {
    @Id
    Integer id
    String name
    double price
}
