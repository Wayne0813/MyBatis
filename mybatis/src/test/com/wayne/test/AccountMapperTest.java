package com.wayne.test;

import com.wayne.entity.Account;
import com.wayne.mapper.AccountMapper;
import com.wayne.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author LV
 * @date 2018/7/10
 */
public class AccountMapperTest {

    @Test
    public void testSave(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        Account account = new Account();
        account.setUserName("rose");
        account.setPassword("123");
        accountMapper.save(account);

        sqlSession.close();
    }

    SqlSession sqlSession;
    AccountMapper accountMapper;

    @Before
    public void before(){
        sqlSession = MyBatisUtils.getSqlSession(true);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void testFindAll(){
        List<Account> accountList = accountMapper.findAll();

        for(Account account : accountList){
            System.out.println(account);
        }

    }

    @After
    public void after(){
        sqlSession.close();
    }




}
