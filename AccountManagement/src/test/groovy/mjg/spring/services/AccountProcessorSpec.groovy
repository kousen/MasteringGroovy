package mjg.spring.services

import mjg.spring.dao.AccountDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

import spock.lang.Specification

@ContextConfiguration("classpath:applicationContext.xml")
@Transactional
class AccountProcessorSpec extends Specification {
    @Autowired
    AccountProcessor accountProcessor
    
    @Autowired
    AccountDAO dao
    
    def "processing test accounts should deduct 1 from each"() {
        given:
        def accounts = dao.findAllAccounts()
        accountProcessor.setAccounts(accounts)
        println accounts

        when:
        def result = accountProcessor.processAccounts()
        
        then:
        result == accounts.size()
    }
}
