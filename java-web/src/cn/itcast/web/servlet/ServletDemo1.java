package cn.itcast.web.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : Hiccup
 * create at : 2020/2/5 3:42 下午
 * description :
 * remark : 快速入门
 **/
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
