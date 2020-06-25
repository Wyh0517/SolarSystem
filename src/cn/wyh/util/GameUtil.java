package cn.wyh.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中常用的工具类，如加载图片等方法
 * @author wyhpc
 *
 */
public class GameUtil {
	
	private GameUtil() {}	//工具类，将构造方法私有化
	
	public static Image getImage(String path) {
		//URL对象
		URL u = GameUtil.class.getClassLoader().getResource(path);
		
		BufferedImage img = null;
		//捕获
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
