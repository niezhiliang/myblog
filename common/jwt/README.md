### springboot集成Jwt


- 依赖

            <dependency>
                <groupId>io.jsonwebtoken</groupId>
                <artifactId>jjwt</artifactId>
                <version>0.9.0</version>
            </dependency>


在项目中使用只需要将App.class 改成@Configuration
然后在主项目启动类中使用@Import(xx.xx.App.class)


#### Jwt主要就是分为三部分

- 1.头部（header）
    头部一般有两部分信息：声明类型、声明加密的算法（通常使用HMAC SHA256）
    头部一般使用base64加密：eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9
    解密后：
- 2.载荷（payload）
    该部分一般存放一些有效的信息。jwt的标准定义包含以下五个字段

        iss：该JWT的签发者
        sub: 该JWT所面向的用户
        aud: 接收该JWT的一方
        exp(expires): 什么时候过期，这里是一个Unix时间戳
        iat(issued at): 在什么时候签发的

- 3.签证（signature）
    JWT最后一个部分。该部分是使用了HS256加密后的数据；包含三个部分：

    header (base64后的)
    payload (base64后的)
    secret 私钥

####  在jwt的过滤器中 定义了一个规则，只要请求地址是以 /unchk/*的地址，都不会拦截 直接放行

所以那些无需拦截的地址 最好在请求地址前面带上/unchk/

#### jwtUtil中提供的方法

    1.验证token是否合法

    2.通过token获取用户的userid
