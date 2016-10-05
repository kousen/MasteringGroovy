package mjg

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;

@ContextConfiguration("classpath:applicationContext.xml")
class POJOIntegrationSpec extends Specification {
    @Autowired
    POJO pojo
    
    def "initial values set from config"() {
        expect:
        pojo.three == 3.0d
    }
    
    def "change values via setters"() {
        when:
        pojo.three = 333.0
        
        then:
        pojo.three == 333.0d
    }
    
}
