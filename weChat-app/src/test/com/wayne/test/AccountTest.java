package com.wayne.test;

import com.wayne.entity.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * @author LV
 * @date 2018/7/9
 */
public class AccountTest {

    @Test
    public void testSave() throws IOException {

        Reader reader = Resources.getResourceAsReader("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        Account account = new Account();
        account.setUserName("jack");
        account.setPassword("123123");

        int res = sqlSession.insert("com.wayne.mapper.AccountMapper.save", account);

        Assert.assertEquals(1, res);

        sqlSession.close();

    }

}
