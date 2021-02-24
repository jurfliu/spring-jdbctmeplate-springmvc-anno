package com.ljf.spring.jp.sm.anno.dao.impl;

import com.ljf.spring.jp.sm.anno.bean.Account;
import com.ljf.spring.jp.sm.anno.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: AccountDaoImpl
 * @Description: TODO
 * @Author: liujianfu
 * @Date: 2021/02/22 18:02:28 
 * @Version: V1.0
 **/
@Repository
public class AccountDaoImpl  implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 相当于：<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
    //        <property name="dataSource" ref="dataSource"></property>
    //    </bean>
    //
    //
    @Override
    public List<Account> findAll() {
        List<Account> accounts = jdbcTemplate.query("select id,account_name accountName,money from tb_account",new BeanPropertyRowMapper<Account>(Account.class));
         return  accounts;
    }

    @Override
    public void saveAccount(Account account) {
        jdbcTemplate.update("insert into tb_account(id,account_name,money) values(?,?,?)",null,account.getAccountName(),account.getMoney());
    }
}
