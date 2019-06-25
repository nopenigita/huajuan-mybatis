package cn.huajuan.web.filter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author : huajuan
 * create at : 2019-05-12 14:56
 * @program: day19_filter
 * 过滤器快速入门
 * /*代表访问所有资源之前,都会执行该过滤器
 * dispatcherType有五种拦截方式 request浏览器直拉请求资源和forward转发 include包含访问资源 error错误跳转资源 async异步访问资源
 **/
@WebFilter(value = "/*", dispatcherTypes = DispatcherType.REQUEST)
public class FilterDemo1 implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    /**
    * create by HuaJuan at 2019/5/12 2:57 PM
    * description:
    * @return: void
    * @param: [servletRequest, servletResponse, filterChain]
    */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FilterDemo1被执行了...");
        //放行
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
