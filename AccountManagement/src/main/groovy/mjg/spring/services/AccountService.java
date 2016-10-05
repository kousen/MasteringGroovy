package mjg.spring.services;

import java.math.BigDecimal;

import mjg.spring.dao.AccountDAO;
import mjg.spring.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountDAO dao;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BigDecimal getAccountBalance(int id) {
        Account account = dao.findAccountById(id);
        return account.getBalance();
    }

    public BigDecimal depositIntoAccount(int id, BigDecimal amount) {
        Account account = dao.findAccountById(id);
        account.deposit(amount);
        dao.updateAccount(account);
        return account.getBalance();
    }

    public BigDecimal withdrawFromAccount(int id, BigDecimal amount) {
        Account account = dao.findAccountById(id);
        account.withdraw(amount);
        dao.updateAccount(account);
        return account.getBalance();
    }

    public boolean transferFunds(int fromId, int toId, BigDecimal amount) {
        Account from = dao.findAccountById(fromId);
        Account to = dao.findAccountById(toId);
        from.withdraw(amount);
        to.deposit(amount);
        dao.updateAccount(from);
        dao.updateAccount(to);
        return true;
    }

}
