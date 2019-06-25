package com.huajuan.dao;

import com.huajuan.domain.User;

import java.util.List;

/**
 * @author huajuan
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

}
