package mjg.spring.dao

import java.sql.ResultSet
import java.util.logging.Logger;

import javax.sql.DataSource

import mjg.spring.entities.Account

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository

@Repository
class JdbcAccountDAO implements AccountDAO {
    static int nextId = 3
    JdbcTemplate jdbcTemplate

    @Autowired JdbcAccountDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource)
    }

    public int createAccount(BigDecimal initialBalance) {
        String sql = "insert into accounts(id,balance) values(?,?)"
		int id = nextId++
        int uc = jdbcTemplate.update(sql, id, initialBalance)
        return id;
    }

    public Account findAccountById(int id) {
        String sql = "select * from accounts where id=?"
        jdbcTemplate.queryForObject(sql, accountMapper, id)
    }
 
//    Java approach: inner class   
//    class AccountMapper implements RowMapper<Account> {
//        @Override
//        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new Account(); // create Account from rs
//        }
//    }

    public List<Account> findAllAccounts() {
        String sql = "select * from accounts"
        jdbcTemplate.query(sql, accountMapper)
    }

    void updateAccount(Account account) {
        String sql = "update accounts set balance=? where id=?"
        jdbcTemplate.update(sql, account.balance, account.id)
    }

    public void deleteAccount(int id) {
        String sql = "delete from accounts where id=?"
        jdbcTemplate.update(sql, id)
    }

    def accountMapper = { ResultSet rs, int row ->
        new Account(id: rs.getInt('id'), 
            balance: rs.getBigDecimal('balance'))
    } as RowMapper<Account>
}








