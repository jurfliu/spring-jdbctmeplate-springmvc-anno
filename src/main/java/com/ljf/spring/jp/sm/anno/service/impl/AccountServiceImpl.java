package com.ljf.spring.jp.sm.anno.service.impl;

import com.ljf.spring.jp.sm.anno.bean.Account;
import com.ljf.spring.jp.sm.anno.dao.AccountDao;
import com.ljf.spring.jp.sm.anno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AccountServiceImpl
 * @Description: TODO
 * @Author: liujianfu
 * @Date: 2021/02/19 23:25:38 
 * @Version: V1.0
 **/
@Service  //相当于
public class AccountServiceImpl implements AccountService {
   @Autowired
    private AccountDao actDao;
   /**
    <bean id="acService" class="com.ljf.spring.jp.sm.demo.service.impl.AccountServiceImpl">
    <property name="actDao" ref="accountDao"></property>
    </bean>
   */
    @Override
    public List<Account> findAll()  {
        List<Account> accountList=new ArrayList<>();
        accountList =actDao.findAll();
        return accountList;
    }

    @Override
    public void saveAccount(Account account) {
        actDao.saveAccount(account);
    }
}
