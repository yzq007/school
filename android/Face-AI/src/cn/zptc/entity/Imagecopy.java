package cn.zptc.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Imagecopy {
	public static void copyFile3(String srcPath, String destPath) throws IOException {
        
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }
        
        // 关闭流  先开后关  后开先关
        fos.close(); // 后开先关
        fis.close(); // 先开后关
        
    }
}
