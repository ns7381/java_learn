package com.nathan.learn.base.jaas;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Map;

public class SimpleLoginModule implements LoginModule {
    private String userName;
    private char[] password;
    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map sharedState;
    private Map options;
    private boolean debug;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map sharedState, Map options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
        this.debug = "true".equalsIgnoreCase((String) options.get("debug"));
    }

    @Override
    public boolean login() throws LoginException {
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("用户名: ");
        callbacks[1] = new PasswordCallback("密码: ", false);

        try {
            callbackHandler.handle(callbacks);
            userName = ((NameCallback) callbacks[0]).getName();
            password = ((PasswordCallback) callbacks[1]).getPassword();
            if (debug) {
                System.out.println("你输入的用户名为:" + userName);
                System.out.println("你输入的密码为:" + new String(password));
            }
            if (userName.equals("admin") && new String(password).equals("123456")) {
                System.out.println("验证成功");
                return true;
            } else {
                System.out.println("验证失败");
                userName = null;
                password = null;
            }
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean commit() throws LoginException {
        System.out.println("commit()");
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        System.out.println("abort()");
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        System.out.println("logout()");
        return false;
    }

}
