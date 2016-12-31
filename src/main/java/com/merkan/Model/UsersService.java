package com.merkan.Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vova on 31.12.2016.
 */
public class UsersService {
    private static final Map<String, String> keyMap = new HashMap<>();
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("Md5");
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("There is no encryption");
        }
    }

    public static boolean addUser(String login, String password) {
        String newPassword = crypt(password);
        keyMap.put(login, newPassword);
        return true;
    }

    public static boolean isUserExist(String login, String password) {
        String requstedPass = crypt(password);
        if(keyMap.get(login).equals(requstedPass)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isLoginPresent(String login) {
        return keyMap.containsKey(login);
    }

    public static String crypt(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }

        md.update(str.getBytes());
        byte[] hash = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            if ((0xff & hash[i]) < 0x10) {
                hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
            }
            else {
                hexString.append(Integer.toHexString(0xFF & hash[i]));
            }
        }
        return hexString.toString();
    }
}
