package com.tw.util;

import java.security.MessageDigest;

/**
 * Created by twer on 7/14/15.
 */
public class MD5Util {
    public static String md5(String str) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                stringBuffer.append(byteToHex(bytes[i]));
            }
            String hex = stringBuffer.toString();
            md5 = hex.toUpperCase();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5;
    }
    public static String byteToHex(byte b) {
        String[] h = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        int i = b;
        if (i < 0) {
            i += 256;
        }
        return h[i / 16] + h[i % 16];
    }

}
