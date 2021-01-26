package com.nathan.learn.base.jaas;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleCallbackHandle implements CallbackHandler {

    @Override
    public void handle(Callback[] callbacks) throws IOException {
        for (Callback callback : callbacks) {
            if (callback instanceof NameCallback) {
                NameCallback nameCallback = (NameCallback) callback;
                System.out.print(nameCallback.getPrompt());
                System.out.flush();
                nameCallback.setName((new BufferedReader(new InputStreamReader(
                        System.in))).readLine());
            } else if (callback instanceof PasswordCallback) {
                PasswordCallback passwordCallback = (PasswordCallback) callback;
                System.out.print(passwordCallback.getPrompt());
                System.out.flush();
                passwordCallback.setPassword((new BufferedReader(new InputStreamReader(
                        System.in))).readLine().toCharArray());
            }
        }
    }
}
