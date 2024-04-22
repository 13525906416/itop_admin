package org.example.itop_admin;

import java.util.Base64;

/**
 * @ClassName Test
 * @Author zhaoyb
 * @Date 2024-04-18
 * @Version 1.0
 */
//@SpringBootTest
public class Test {
    public static void main(String[] args) {
        String str = "user" + ":" + "password";

        System.out.println(Base64.getEncoder().encodeToString(str.getBytes()));
    }
}
