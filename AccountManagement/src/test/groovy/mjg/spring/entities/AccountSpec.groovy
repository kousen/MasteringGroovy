package mjg.spring.entities

import mjg.spring.entities.Account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional

import spock.lang.Specification

@ContextConfiguration("classpath:applicationContext.xml")
class AccountSpec extends Specification {
    @Autowired
    ApplicationContext ctx
	
	@Autowired
	Account account
    
    def "prototype accounts have consecutive ids and balance 100"() {
        when:
        Account a1 = (Account) ctx.getBean("prototypeAccount")
        Account a2 = (Account) ctx.getBean("prototypeAccount")
        Account a3 = (Account) ctx.getBean("prototypeAccount")
        
        then:
        a3.id == a2.id + 1
        a2.id == a1.id + 1
        a1.balance == 100.0
        a2.balance == 100.0
        a3.balance == 100.0
    }
	
	def 'get and set balance'() {
		when:
		account.balance = 100.0
		
		then:
		account.balance == 100.0
	}
	
	def 'deposit works properly'() {
		when:
		account.deposit(100)
		
		then:
		account.balance == old(account.balance) + 100
	}
	
	def 'withdraw works properly'() {
		when:
		account.withdraw(100)
		
		then:
		account.balance == old(account.balance) - 100
	}
	
	def "accounts have equals and hashCode methods"() {
		given:
		Account a1 = (Account) ctx.getBean("prototypeAccount")
		Account a2 = (Account) ctx.getBean("prototypeAccount")
		Account a3 = (Account) ctx.getBean("prototypeAccount")
		
		when:
		a2.id = a1.id
		Set accounts = [a1, a2, a3]
		
		then:
		a1 == a2
		a1 != a3
		accounts.size() == 2
	}
}
