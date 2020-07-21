package com.cwfit.config;

import com.cwfit.pojo.User;
import com.cwfit.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yeyike
 * @date 2020/5/11 - 16:09
 */
//自定义的 UserRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserServiceImpl userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("user:add");
        //拿到当前登录的对象

//        //设置当前用户的权限
//        info.addStringPermission(currentUser.getPerms());
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //链接真实的数据库
        String name = userToken.getUsername();
        User user = userService.queryUserByName(name);

        System.out.println("执行了=>认证doGetAuthenticationInfo");
        if (user==null){
            return null;
        }

        Subject subject = SecurityUtils.getSubject();
        User currentUser =(User) subject.getPrincipal();//拿到User对象
        System.out.println(currentUser);

        return new SimpleAuthenticationInfo("",user.getPassword(),"");
    }
}
