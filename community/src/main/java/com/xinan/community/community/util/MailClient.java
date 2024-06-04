package com.xinan.community.community.util;

// 封装发送邮件的功能 - 邮箱客户端

import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailClient {

    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    @Autowired
    // 邮件的 Sender
    private JavaMailSender mailSender;

    // @Value 的作用是从配置文件 application.properties 中读取配置，并赋值给变量
    @Value("${spring.mail.username}")
    private String from;

    public void sendMail(String to, String subject, String content) {
        try{
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);  // true 表示支持 HTML 格式的文本
            mailSender.send(helper.getMimeMessage());   // 从 helper 中获取 MimeMessage 对象，然后发送
        } catch (Exception e) {
            logger.error("发送邮件失败：" + e.getMessage());
        }
    }
}
