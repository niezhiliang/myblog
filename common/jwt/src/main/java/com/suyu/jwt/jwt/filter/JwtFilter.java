package com.suyu.jwt.jwt.filter;

import com.suyu.domain.User;
import com.suyu.jwt.jwt.util.JwtUtil;
import org.apache.log4j.Logger;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Suyu
 * @Date: Created in 上午9:30 2018/2/6
 */
public class JwtFilter extends GenericFilterBean {
    private static final Logger logger = Logger.getLogger(JwtFilter.class);

    private JwtUtil jwtUtil = new JwtUtil();
    /**
     *  Reserved claims（保留），它的含义就像是编程语言的保留字一样，属于JWT标准里面规定的一些claim。JWT标准里面定好的claim有：
     iss(Issuser)：代表这个JWT的签发主体；
     sub(Subject)：代表这个JWT的主体，即它的所有人；
     aud(Audience)：代表这个JWT的接收对象；
     exp(Expiration time)：是一个时间戳，代表这个JWT的过期时间；
     nbf(Not Before)：是一个时间戳，代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的；
     iat(Issued at)：是一个时间戳，代表这个JWT的签发时间；
     jti(JWT ID)：是JWT的唯一标识。
     * @param req
     * @param res
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        System.out.println("jwt过滤器");
        /** 如果是不需要拦截的直接放行 */
        if (url.startsWith("/unchk/")) {
            //登陆接口不校验token，直接放行
            chain.doFilter(req, res);
            return;
        }
        //等到请求头信息authorization信息
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            logger.warn("JwtFilter logger : Heard not with Authorization or style is not accord with");
            request.getRequestDispatcher("/unchk/login/notoken").forward(req, res);
        } else {
        /** 将正确的token截取出来 去掉bearer 前缀 */
        final String token = authHeader.substring(7);
        boolean bool = JwtUtil.getInstance().checkToken(token,new User("admin","admin"));
        if (bool) {
        chain.doFilter(req,res);
        } else {
            request.getRequestDispatcher("/unchk/error/").forward(req, res);
        }
        }
    }
}
