package cn.zptc.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Imagecopy {
	public static void copyFile3(String srcPath, String destPath) throws IOException {
        
        // ��������
        FileInputStream fis = new FileInputStream(srcPath);
        // �������
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // ��ȡ��д����Ϣ
        int len = 0;
        // ����һ���ֽ����飬����������
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b);
        }
        
        // �ر���  �ȿ����  ���ȹ�
        fos.close(); // ���ȹ�
        fis.close(); // �ȿ����
        
    }
}
