package mjg

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import org.springframework.stereotype.Repository

@Repository
class ProductDAO {
    @PersistenceContext
    EntityManager entityManager

    List<Product> getAllProducts() {
        entityManager.createQuery("select p from Product p")
                .getResultList();
    }

    Product findProductById(int id) {
        entityManager.find(Product.class, id)
    }

    int insertProduct(Product p) {
        entityManager.persist(p)
        p.id
    }

    void deleteProduct(int id) {
        entityManager.remove(findProductById(id))
    }
}
