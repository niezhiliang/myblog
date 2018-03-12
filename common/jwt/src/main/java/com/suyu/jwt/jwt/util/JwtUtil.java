package com.suyu.jwt.jwt.util;

import com.suyu.domain.User;
import com.suyu.jwt.config.JwtConfig;
import com.suyu.jwt.config.JwtParams;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import io.jsonwebtoken.Clock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Suyu
 * @Date   Created in 上午9:54 2018/2/6
 */
@Component
public class JwtUtil {
    static final String AUDIENCE_UNKNOWN = "unknown";
    static final String AUDIENCE_WEB = "web";
    static final String AUDIENCE_MOBILE = "mobile";
    static final String AUDIENCE_TABLET = "tablet";
    private Clock clock = DefaultClock.INSTANCE;
    @Autowired
    private JwtParams jwt;
    private JwtConfig jwtConfig = new JwtConfig();
    /**
     * 工厂模式
     */
    private static JwtUtil instance;
    public static synchronized JwtUtil getInstance(){
        if (instance == null) {
            instance = new JwtUtil();
        }
        return instance;
    }
    /**
     * 生成token
     */
    public String generateToken(User user) {
        final Date createDate = clock.now();
        /** jwt 载荷部分 可以自定义多个键值对 全会加密到token里面*/
        Map<String,Object> claims = new HashMap<String, Object>();
        claims.put("userid",user.getId());
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())//token的所有人
                .setAudience("web")//终端
                .setIssuedAt(createDate)//token创建时间
                .setExpiration(calculateExpirationDate(createDate))//token过期时间
                .signWith(SignatureAlgorithm.HS512,jwtConfig.secret)//token加密方式
                .compact();
    }

    /**
     *算出token的过期时间
     */
    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + jwtConfig.expiration * 1000);
    }

    /**
     * token中取出userid
     */
    public String getUserIdByToken (String token) {
        return getAllClaimsFromToken(token).get("userid").toString();
    }

    /**
     *解析出载荷map集合
     */
    public Claims getAllClaimsFromToken(String token) {
       Claims claims = Jwts.parser()
                .setSigningKey(jwtConfig.secret)
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }

    /**
     * 验证token是否合法
     */
    public boolean checkToken(String token,User user) {
        final String username = getSubject(token);
        final Date expirationDate = getExpirationDateFromToken(token);
        System.out.println(expirationDate);
        final Date nowDate = clock.now();
        if (user.getUsername().equals(username)) {
            if (!expirationDate.before(nowDate)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 取出token的过期时间
     */
    private Date getExpirationDateFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        Object obj = claims.get(Claims.EXPIRATION);
        Integer date = (Integer) obj;
        return new Date(date.longValue()*1000);
    }

    /**
     * 取出token中的username(当前token所属用户)
     */
    private String getSubject(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.get(Claims.SUBJECT).toString();
    }



}
