package encode;

/**
 * Author: zouy
 * Unit: D9lab
 * Date: 2018-07-24 10:35
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 *
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */

public class RSACoderTest {
    private static String publicKey;
    private static String privateKey;

    public static void main(String[] args) {
        publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKf9c6sVP4QcxWXC4bpPjD1F/g/6jf8ZasEs0v" +
                "ig02kYZA1frLeH/MMMeLse5DDAVJd526od6d8zahYM0W1KyKS9dAC8mWoXdu8EeqE7Oy4DgOm41s" +
                "PkWQV+VSnfmhF3DBvkxmeR2hE9LFAS5+xDaYjGvru9m6e3ScyDo4QKLkYwIDAQAB";
        privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIp/1zqxU/hBzFZcLhuk+MPUX+D/" +
                "qN/xlqwSzS+KDTaRhkDV+st4f8wwx4ux7kMMBUl3nbqh3p3zNqFgzRbUrIpL10ALyZahd27wR6oT" +
                "s7LgOA6bjWw+RZBX5VKd+aEXcMG+TGZ5HaET0sUBLn7ENpiMa+u72bp7dJzIOjhAouRjAgMBAAEC" +
                "gYBRmDNivqnrrkgF8NSxMKXmKS47TiNdm+Tah1Ee2sQiC+X+OJJCYUFZOLu2zyLBmUlcGP5xv395" +
                "qpnaxT7OXokvKObWW4cscE1zPsMknUP/8ugLHS8Fs90mLn9Vv3xLUEognQYvhaczuKsAFfAD8ebJ" +
                "cZv1pmiMHb0EfnEUC4UiAQJBANbUnQxmC4zfhTlmr4kFYmBpp7SsMCaFgJue/RlSK5BsBcXFqNDt" +
                "mDotz+8Wn8CFQ0PwZS4VhcGrT1mEUtiUvuMCQQClCn31Ll4d0tw6CfjUD+tTlNz30B9WY4AtHTy3" +
                "C4GybMJlCMXTo3X5aZjPGVSjbXf4hhYL7bIQpoEqnnzQgLyBAkEAlWvWO/xyBi6ljBI2/1fGYAa8" +
                "xbaJ2xE6LYN8yPLVKCNqNG/RhlfrbHPWz5Xt0UsfSQ7YYSBJIzZS/5FAyjFTPwJADu0G/TCHVH0o" +
                "a5tRRKR37OQuo77PxrlS80GMpyVEQoWxgv+rHHvRBJB3QGuTCwCwc+p0ffmuO/FDBz60HQs3gQJA" +
                "IoURqXrV/I4BLgjDJroGG9sDyhoKp4C330LL/E0uFSzW2ioO1adnP/fVM8Ap3+c2VFnfOaktrhLQ" +
                "6oGcD9r9DA==";
        try {
            test();
            //testSign();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUp() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();

        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.err.println("公钥: \n\r" + publicKey);
        System.err.println("私钥： \n\r" + privateKey);
    }

    public static void test() throws Exception {
        System.err.println("公钥加密——私钥解密");
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);

        System.out.println(new String(encodedData));

        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData,
                privateKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
    }

    public static void testSign() throws Exception {
        System.err.println("私钥加密——公钥解密");
        String inputStr = "sign";
        byte[] data = inputStr.getBytes();

        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);

        byte[] decodedData = RSACoder
                .decryptByPublicKey(encodedData, publicKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);

        System.err.println("私钥签名——公钥验证签名");
        // 产生签名
        String sign = RSACoder.sign(encodedData, privateKey);
        System.err.println("签名:\r" + sign);

        // 验证签名
        boolean status = RSACoder.verify(encodedData, publicKey, sign);
        System.err.println("状态:\r" + status);
    }

}

