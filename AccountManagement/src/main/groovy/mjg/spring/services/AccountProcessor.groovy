package mjg.spring.services

import mjg.spring.entities.Account

class AccountProcessor {
    List<Account> accounts
    BigDecimal monthlyFee = 1.0

    def processAccounts() {
        accounts.collect { a ->
            a.withdraw(monthlyFee)
            monthlyFee
        }.sum()
    }

}
