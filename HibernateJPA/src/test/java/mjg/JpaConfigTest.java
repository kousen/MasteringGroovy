package mjg;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
@Transactional
public class JpaConfigTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void getSingleAccount() {
        Product p = (Product) entityManager.createQuery(
                "select p from Product p where p.id=:id")
                .setParameter("id", 1)
                .getSingleResult();
        assertEquals("baseball", p.getName());
    }
    
    @SuppressWarnings("unchecked")
    @Test
    public void getAllAccounts() {
        List<Product> products = entityManager.createQuery(
                "select p from Product p")
                .getResultList();
        assertEquals(3, products.size());
    }
}
