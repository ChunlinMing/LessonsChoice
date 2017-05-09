package com.mcl.bysj.utils;

import com.mcl.bysj.entity.LoginInfo;
import org.apache.commons.codec.binary.Base64;
import org.springframework.mail.SimpleMailMessage;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

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
     * 检查一个List<String>对象中是否有元素为空
     * @param list List对象
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

    /**
     * 产生15位随机字符串
     * @return 随机字符串
     */
    public static String produceValidationCode()
    {
        String str = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < 15;i++)
        {
            sb.append(str.charAt(new Random().nextInt(62)));
        }
        return sb.toString();
    }

    public static SimpleMailMessage mailConfig(String toMail, String userId, String code) throws Exception
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1432608191@qq.com");//发送者
        message.setTo(toMail);//接收者
        message.setSubject("邮件验证码");//邮件主题
        message.setText(userId + "，这是你的邮件验证码：" + code);//邮件内容
        return message;
    }
}
