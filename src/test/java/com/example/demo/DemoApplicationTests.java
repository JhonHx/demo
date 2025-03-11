package com.example.demo;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws IOException  {
        Map<String, Object> dataMap = MapUtil.builder(new HashMap<String, Object>())
                .put("certName", "生产车间操作考核证书")
                .put("userName", "张三")
                .put("department", "横店集团-南京子公司-操作车间-1车间")
                .put("trainName", "车间操作培训")
                .put("certNumber", "hg20250311001")
                .put("certGenerationDate", "2025-03-11")
                .put("loginUserId", "zhangsan")
                .put("certValidityPeriod", "2035-03-11")
                .build();

        String backgroundImagePath = "/static/background.png";
        String logoImagePath = "/static/logo.png";
        String signatureImagePath = "/static/signature.png";

        InputStream backgroundImageInputStream = this.getClass().getResourceAsStream(backgroundImagePath);
        BufferedImage backgroundImage = ImageIO.read(backgroundImageInputStream);
        BufferedImage combinedImage = new BufferedImage(backgroundImage.getWidth(), backgroundImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
        // 获取Graphics2D对象，用于绘制
        Graphics2D g2d = combinedImage.createGraphics();
        // 绘制背景图片
        g2d.drawImage(backgroundImage, 0, 0, null);

        // 在背景图片上绘制叠加图片
        InputStream logoImageInputStream = this.getClass().getResourceAsStream(logoImagePath);
        BufferedImage logoImage = ImageIO.read(logoImageInputStream);
        // 居中
        int logoImageX = (backgroundImage.getWidth() - logoImage.getWidth()) / 2;
        g2d.drawImage(logoImage, logoImageX, 72, null);

        InputStream signatureImageInputStream = this.getClass().getResourceAsStream(signatureImagePath);
        BufferedImage signatureImage = ImageIO.read(signatureImageInputStream);
        g2d.drawImage(signatureImage, 370, 623, null);

        // 设置字体和颜色
        String fontFamily = "微软雅黑";
        int fontSize40 = 40;
        Font certNameFont = new Font(fontFamily, Font.BOLD, fontSize40);
        String certName = dataMap.get("certName").toString();
        // 获取文字的宽度和高度
        FontRenderContext fontRenderContext1 = g2d.getFontRenderContext();
        Rectangle2D textBounds1 = certNameFont.getStringBounds(certName, fontRenderContext1);
        int certNameTextWidth = (int) textBounds1.getWidth();
        int certNameTextHeight = (int) textBounds1.getHeight();
        g2d.setFont(certNameFont);
        g2d.setColor(new Color(25,121,57));
        // 在背景图片上绘制文字
        g2d.drawString(certName , (backgroundImage.getWidth() - certNameTextWidth) / 2, 164 + certNameTextHeight);

        int fontSize30 = 30;
        Font userNameFont = new Font(fontFamily, Font.BOLD, fontSize30);
        String userName = dataMap.get("userName").toString();
        FontRenderContext fontRenderContext2 = g2d.getFontRenderContext();
        Rectangle2D textBounds2 = userNameFont.getStringBounds(userName, fontRenderContext2);
        int userNameTextWidth = (int) textBounds2.getWidth();
        int userNameTextHeight = (int) textBounds2.getHeight();
        g2d.setFont(userNameFont);
        g2d.setColor(new Color(44,46,44));
        g2d.drawString(userName , (backgroundImage.getWidth() - userNameTextWidth) / 2, 274 + userNameTextHeight);

        int fontSize18 = 18;
        Font departmentFont = new Font(fontFamily, 0, fontSize18);
        String department = dataMap.get("department").toString();
        FontRenderContext fontRenderContext3 = g2d.getFontRenderContext();
        Rectangle2D textBounds3 = departmentFont.getStringBounds(department, fontRenderContext3);
        int departmentTextWidth = (int) textBounds3.getWidth();
        int departmentTextHeight = (int) textBounds3.getHeight();
        g2d.setFont(departmentFont);
        g2d.setColor(new Color(102,104,103));
        g2d.drawString(department , (backgroundImage.getWidth() - departmentTextWidth) / 2, 318 + departmentTextHeight);

        int fontSize16 = 16;
        Font trainNameFont = new Font(fontFamily, 0, fontSize16);
        String trainName = dataMap.get("trainName").toString() + "已全部完成，特颁发此证";
        FontRenderContext fontRenderContext4 = g2d.getFontRenderContext();
        Rectangle2D textBounds4 = trainNameFont.getStringBounds(trainName, fontRenderContext4);
        int trainNameTextWidth = (int) textBounds4.getWidth();
        int trainNameTextHeight = (int) textBounds4.getHeight();
        g2d.setFont(trainNameFont);
        g2d.setColor(new Color(33,33,33));
        g2d.drawString(trainName , (backgroundImage.getWidth() - trainNameTextWidth) / 2, 451 + trainNameTextHeight);

        int fontSize14 = 14;
        Font font14 = new Font(fontFamily, 0, fontSize14);
        String certNumber = "证书编号：" + dataMap.get("certNumber").toString();
        FontRenderContext fontRenderContext51 = g2d.getFontRenderContext();
        Rectangle2D textBounds51 = font14.getStringBounds(certNumber, fontRenderContext51);
        int certNumberTextWidth = (int) textBounds51.getWidth();
        int certNumberTextHeight = (int) textBounds51.getHeight();
        g2d.setFont(font14);
        g2d.setColor(new Color(10,94,28));
        g2d.drawString(certNumber , (backgroundImage.getWidth() - certNumberTextWidth) / 2, 513 + certNumberTextHeight);

        int lineHeight = 10;

        String certGenerationDate = "证书生成日期：" + dataMap.get("certGenerationDate").toString();
        FontRenderContext fontRenderContext52 = g2d.getFontRenderContext();
        Rectangle2D textBounds52 = font14.getStringBounds(certGenerationDate, fontRenderContext52);
        int certGenerationDateTextWidth = (int) textBounds52.getWidth();
        int certGenerationDateTextHeight = (int) textBounds52.getHeight();
        g2d.drawString(certGenerationDate , (backgroundImage.getWidth() - certGenerationDateTextWidth) / 2, lineHeight + 513 + certNumberTextHeight + certGenerationDateTextHeight);

        String loginUserId = "登录系统工号：" + dataMap.get("loginUserId").toString();
        FontRenderContext fontRenderContext53 = g2d.getFontRenderContext();
        Rectangle2D textBounds53 = font14.getStringBounds(loginUserId, fontRenderContext53);
        int loginUserIdTextWidth = (int) textBounds53.getWidth();
        int loginUserIdTextHeight = (int) textBounds53.getHeight();
        g2d.drawString(loginUserId , (backgroundImage.getWidth() - loginUserIdTextWidth) / 2, lineHeight * 2 + 513 + certNumberTextHeight + certGenerationDateTextHeight + loginUserIdTextHeight);

        String certValidityPeriod = "证书有效期：" + dataMap.get("certValidityPeriod").toString();
        FontRenderContext fontRenderContext54 = g2d.getFontRenderContext();
        Rectangle2D textBounds54 = font14.getStringBounds(certValidityPeriod, fontRenderContext54);
        int certValidityPeriodTextWidth = (int) textBounds54.getWidth();
        int certValidityPeriodTextHeight = (int) textBounds54.getHeight();
        g2d.drawString(certValidityPeriod , (backgroundImage.getWidth() - certValidityPeriodTextWidth) / 2, lineHeight * 3 + 513 + certNumberTextHeight + certGenerationDateTextHeight + loginUserIdTextHeight + certValidityPeriodTextHeight);

        // 释放Graphics2D对象
        g2d.dispose();
        ImageIO.write(combinedImage, "PNG", new File("d:/imageTest/" + System.currentTimeMillis() + ".png"));
        System.out.println(System.currentTimeMillis());

    }

}
