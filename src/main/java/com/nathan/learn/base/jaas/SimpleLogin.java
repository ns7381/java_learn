package com.nathan.learn.base.jaas;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *  通过命令行方式进行验证
 *  java -Djava.security.auth.login.config==jaas.config com.base.jaas.SimpleLogin
 */
public class SimpleLogin {

    public static void main(String[] args) throws LoginException {
        LoginContext loginContext = new LoginContext("simple", new SimpleCallbackHandle());
        loginContext.login();
    }

}