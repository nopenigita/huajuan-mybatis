package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author : Hiccup
 * create at : 2020/2/6 4:10 下午
 * description :
 * remark : 操作数据库中User表的类
 **/
public class UserDao {

    /**
     * 声明jdbcTemplate对象共用
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 包含用户的全部数据
     */
    public User login(User loginUser){
        try{
            // 编写SQL
            String sql = "select * from user where username = ? and password = ?";
            // 调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
