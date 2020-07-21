package com.cwfit.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yeyike
 * @date 2020/5/11 - 16:06
 */
@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("getDefaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        //拦截
        Map<String ,String> filterMap = new LinkedHashMap<>();
        //授权
        filterMap.put("/goLogin","anon");
        filterMap.put("/goRegister","anon");
        filterMap.put("/goHomePage","perms[user:add]");
        filterMap.put("homepage","perms[user:add]");
        filterMap.put("/goPlay","perms[user:add]");

//        filterMap.put("/user/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //设置登录请求
        bean.setLoginUrl("/goLogin");
        //未授权页面
        bean.setUnauthorizedUrl("/noauth");
        return bean;

    }
    //DefaultWebSecurityManager
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    //创建 realm 对象，需要自定义类
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
    //整合ShiroDialect:用来整合 shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

    @RequestMapping("/goPlay")
    public String goPlay(){
        return "playspace";
    }
}
