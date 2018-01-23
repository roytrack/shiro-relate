package com.roytrack.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/***
 *
 *   Created by roytrack on 2018-01-20  20:14
 */
public class MyRealm2 implements Realm {
    @Override
    public String getName() {
        return "myrealm2";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName=(String)authenticationToken.getPrincipal();
        String password=new String((char[]) authenticationToken.getCredentials());
        if(!"ruan".equals(userName)){
            throw new UnknownAccountException();
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(userName,password,getName());

    }
}
