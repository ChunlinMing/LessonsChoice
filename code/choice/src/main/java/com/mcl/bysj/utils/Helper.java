package com.mcl.bysj.utils;

import com.mcl.bysj.entity.LoginInfo;
import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    /**
     * 根据session中用户类型跳转到相应页面
     * @param userType 用户类型编号
     * @return 相应的页面
     */
    public static String checkUserType(Integer userType)
    {
        if (null != userType)
        {
            if (0 == userType)
            {
                return "redirect:/manager";
            }
            if (1 == userType)
            {
                return "redirect:/teacher";
            }
            if (2 == userType)
            {
                return "redirect:/stu";
            }
        }
        return "login";
    }

    /**
     * 判断用户名密码是否正确
     * @param userType 用户类型编号
     * @param loginInfo 用户登录信息
     * @param session 用户登录状态
     * @return 是否登录成功
     */
    public static boolean checkUserType(Integer userType, LoginInfo loginInfo, HttpSession session)
    {
        if (null != userType)
        {
            if (userType == 0 || userType == 1 || userType == 2)
            {
                session.setAttribute("userId",loginInfo.getUserId());
                session.setAttribute("userType",userType);
                return true;
            }
        }

        return false;
    }

    /**
     * 检查某个所有属性都为String类型的对象中是否有属性为空
     * @param args 属性数组
     * @return true OR false
     */
    public static boolean checkEmpty(List<String> list)
    {
        for (String str : list)
        {
            if (isEmpty(str))
            {
                return true;
            }
        }
        return false;
    }
}
