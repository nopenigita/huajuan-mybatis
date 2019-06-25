package com.huajuan.test;

import com.huajuan.dao.IUserDao;
import com.huajuan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : huajuan
 * create at : 2019-06-22 14:39
 * description :
 * remark : mybatis入门案例
 * @program: day01_mybaits
 **/
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        //1 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2 创建SqlSessionFactory 工厂模式
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3 使用工厂模式创建SqlSession对象
        SqlSession session = factory.openSession();
        //4 使用SqlSession创建Dao接口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        //5 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //6 释放资源
        session.close();
        in.close();

    }
}
