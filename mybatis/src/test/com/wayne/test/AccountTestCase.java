package com.wayne.test;

import com.wayne.entity.Account;
import com.wayne.util.MyBatisUtils;
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
 * @date 2018/7/10
 */
public class AccountTestCase {

    @Test
    public void testSave()throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        Account account = new Account();
        account.setUserName("jack");
        account.setPassword("123456");
        int res = sqlSession.insert("com.wayne.mapper.AccountMapper.save", account);

        Assert.assertEquals(1, res);
        sqlSession.close();

    }

    @Test
    public void testSave1(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        Account account = new Account();
        account.setUserName("jack");
        account.setPassword("123");
        int res = sqlSession.insert("com.wayne.mapper.AccountMapper.save", account);
        Assert.assertEquals(1, res);
        sqlSession.close();
    }


}
