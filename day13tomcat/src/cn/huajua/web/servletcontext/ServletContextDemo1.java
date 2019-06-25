package cn.huajua.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huajuan
 */
@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
        * create by HuaJuan at 2019/5/11 8:35 PM
        * description:演示ServletContext对象获取
        * @return: void
        * @param: [request, response]
        */
        // 1 方式 通过request获取
        ServletContext sc = request.getServletContext();
        // 2 方式 HttpServlet获取
        ServletContext sc2 = this.getServletContext();
        //结果为true
        System.out.println(sc == sc2);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
