package com.mcl.bysj.utils;

import org.apache.commons.codec.binary.Base64;
/**
 * 工具类
 * Created by mingchunlin on 17/4/14.
 */
public class Helper
{
    /**
     * 对用户密码进行加密
     * @param password 从前台获得的加密串
     * @param length 真正密码的长度
     * @return String 经两次加密后的用户密码
     */
    public static String EncodePwd(String password, int length)
    {
        String encodedTruePwd = null;
        try
        {
            byte[] decodedPwd = RSAUtils.decrypt(RSAUtils.byteToPrivateKey(Base64.decodeBase64(PropReadUtil.getInstance().getResources("PRIVATE_KEY_BYTES"))),
                    Base64.decodeBase64(password));
            String pwd = new String(decodedPwd);
            String truePwd = pwd.substring(pwd.length() - length - 1,pwd.length());
            byte[] encodedPwd = RSAUtils.encrypt(
                    RSAUtils.byteToPublicKey(Base64.decodeBase64(PropReadUtil.getInstance().getResources("PUBLIC_KEY_BYTES"))),
                    truePwd.getBytes());
            encodedTruePwd = RSAUtils.b2hex(RSAUtils.EncodeByMd5(new String(Base64.encodeBase64(encodedPwd))).getBytes("utf-8"));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return encodedTruePwd;
    }

    /**
     * 判断字符串是否为空
     * @param str 要检查的字符串
     * @return boolean
     */
    public static boolean isEmpty(String str)
    {
        return (str == null || "".equals(str));
    }
}
