package cn.wyh.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г��õĹ����࣬�����ͼƬ�ȷ���
 * @author wyhpc
 *
 */
public class GameUtil {
	
	private GameUtil() {}	//�����࣬�����췽��˽�л�
	
	public static Image getImage(String path) {
		//URL����
		URL u = GameUtil.class.getClassLoader().getResource(path);
		
		BufferedImage img = null;
		//����
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
