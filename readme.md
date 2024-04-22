# yb_admin后台管理系统后端

## v1 环境准备
* JDK 21
* SpringBoot 3.2.0
* Mysql 8.2.0
* Mybatis-plus 3.5.4
* Maven 3.6.3
* Windows 11

1. 生成公钥和密钥
    ```shell
   keytool -genkeypair -alias xxxx_key -keyalg RSA -keypass xxxxxx -keystore auth.jks -storepass xxxxxx -dname CN=xxx
   keytool -genkeypair -alias ybkey -dname "CN=yb, OU=itop, O=My Org Unit, L=My City, S=My State, C=China" -keyalg RSA -sigalg SHA256withRSA --keysize 2048 --output app.pub --storetype PKCS12
2. 解释上述命令
   * -genkeypair 表示生成密钥对
   * -alias 设置别名


