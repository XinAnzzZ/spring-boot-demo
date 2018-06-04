package com.java.myh.util;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author 心安
 * @date 2018/6/3 15:28
 */
public class MailUtils {
    private static Message message;
    private static Transport transport;

    private static void init() throws GeneralSecurityException {
        Properties properties = new Properties();

        //使用MailSSLSocketFactory避免了需要添加证书，你的密钥库如上所述,或配置自己的TrustManager。
        properties.setProperty("mail.smtp.ssl.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.fallback", "false");

        properties.put("mail.smtp.ssl.socketFactory", new MailSSLSocketFactory());

//        properties.setProperty("mail.smtp.socketFactory.port", "465");

        //发件人邮箱主机名
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        //邮件服务器端口
        properties.setProperty("mail.smtp.port", "465");
        //发件协议
//        properties.setProperty("mail.transport.protocol", "smtp");
        //身份验证设置
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("13023195022@163.com", "xinan9508060");
            }
        });
        message = new MimeMessage(session);
        try {
            message.setSubject("快云网盘邮箱验证邮件");
            //设置发件人
            message.setFrom(new InternetAddress("13023195022@163.com"));
            transport = session.getTransport();
            //设置发件人在该邮箱主机上的用户名密码
            transport.connect("13023195022@163.com", "xinan9508060");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 发送随机验证码邮件
     *
     * @param emailAddress 邮箱地址
     * @param code         随机验证码
     */
    public static void sendEmail(String emailAddress, String code) {
        try {
            init();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        String emailContent = "感谢您使用快云网盘，您的验证码是" + code
                + "，请勿将该验证码告知别人！";
        try {
            message.setText(emailContent);
            transport.sendMessage(message, new Address[]{new InternetAddress(emailAddress)});
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //阿里SMTP服务器地址
    private static final String ALIDM_SMTP_HOST = "smtp.aliyun.com";
    private static final int ALIDM_SMTP_PORT = 25;

    public static void main(String[] args) throws MessagingException {

    }

    public static void sendMail() throws MessagingException {
        // 配置发送邮件的环境属性
        final Properties props = new Properties();
        // 表示SMTP发送邮件，需要进行身份验证
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", ALIDM_SMTP_HOST);
//        props.put("mail.smtp.port", ALIDM_SMTP_PORT);
        // 如果使用ssl，则去掉使用25端口的配置，进行如下配置,
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.port", "465");


        // 发件人的账号
        props.put("mail.user", "xinan950806@aliyun.com");
        // 访问SMTP服务时需要提供的密码(邮箱密码)
        props.put("mail.password", "xinan950806");

        // 构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // 使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        // 创建邮件消息
        MimeMessage message = new MimeMessage(mailSession);
        // 设置发件人
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // 设置收件人
        InternetAddress to = new InternetAddress("1150989249@qq.com");
        message.setRecipient(MimeMessage.RecipientType.TO, to);

        // 设置邮件标题
        message.setSubject("测试邮件");
        // 设置邮件的内容体
        message.setContent("测试的HTML邮件", "text/html;charset=UTF-8");

        // 发送邮件
        Transport.send(message);
    }
}
