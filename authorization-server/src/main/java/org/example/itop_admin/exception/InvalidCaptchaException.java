package org.example.itop_admin.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @ClassName InvalidCaptchaException  验证码异常类
 * @Author zhaoyb
 * @Date 2024-05-24
 * @Version 1.0
 */
public class InvalidCaptchaException extends AuthenticationException {

    public InvalidCaptchaException(String msg) {
        super(msg);
    }

}

