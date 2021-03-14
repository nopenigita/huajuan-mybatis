package cn.itcast.test;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import org.junit.Test;

/**
 * @author : Hiccup
 * create at : 2020/2/6 4:26 下午
 * description :
 * remark :
 **/
public class UserDaoTest {
    @Test
    public void testLogin(){
        User loginUser = new User();
        loginUser.setUsername("TM");
        loginUser.setPassword("123456");
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
