package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : huajuan
 * create at : 2019-12-04 00:31
 * description :
 * remark : 控制器类
 * @program: springMVC
 **/
@Controller
public class HelloController {

    private static final String SUCCESS = "success";

    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("hello Spring mvc");
        return SUCCESS;
    }

}
