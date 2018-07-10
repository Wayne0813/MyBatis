package com.wayne.mapper;


import com.wayne.entity.Account;

import java.util.List;

/**
 * @author LV
 * @date 2018/7/10
 */
public interface AccountMapper {

    int save(Account account);
    List<Account> findAll();


}
