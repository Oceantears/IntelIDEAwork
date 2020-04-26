/**
 * 二维码测试类
 */
package com.it.QrCode;

/**
 * @author Laotian
 * @date 2020-03-20 15:57
 */
public class QrCodeTest {
    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "我是小铭";
        // 嵌入二维码的图片路径
        //String imgPath = "G:/qrCode/dog.jpg";
        // 生成的二维码的路径及名称
        String destPath = "D:/abc/comitzonghengfarmers/src/main/webapp/images/1.jpg";
        //生成二维码
        QRCodeUtil.encode(text, /*imgPath,*/ destPath);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);

    }
}