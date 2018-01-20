package com.roytrack.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/***
 *
 *   Created by roytrack on 2018-01-20  16:52
 */
public class LoginLogoutTest {

    @Test
    public void testHelloWorld(){
        //获取SecurityManage工厂 用ini初始化
        Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager =factory.getInstance();


        SecurityUtils.setSecurityManager(securityManager);

        Subject subject=SecurityUtils.getSubject();

        UsernamePasswordToken token=new UsernamePasswordToken("roy","123");

        try{
            subject.login(token);
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("登录失败");
        }


        Assert.assertEquals(true,subject.isAuthenticated());

        subject.logout();



    }
}
