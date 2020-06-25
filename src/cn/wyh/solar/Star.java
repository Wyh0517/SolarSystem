package cn.wyh.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.wyh.util.GameUtil;

/**
 * 恒星行为及属性
 * 加载图片，控制恒星的位置
 * @author wyhpc
 *
 */
public class Star {
	Image img;	//图片
	double x,y;	//坐标
	int width,height;	//图片大小
	Star star;	//Star对象
	
	public void draw(Graphics g) {
		//画星星
		g.drawImage(img, (int)x, (int)y, null);		
	}
	
	public Star() {}	//父类的空构造器

	//重载构造器
	public Star(Image img) {
		this.img = img;					//加载图片
		this.width = img.getWidth(null);	//获取图片高度
		this.height = img.getHeight(null);	//获取图片宽度
	}
	
	//重载构造器
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;		//横坐标
		this.y = y;		//纵坐标
	}
	
	//重载构造器，用于传参
	public Star(String imgPath, double x, double y) {
//		this.img = GameUtil.getImage(imgPath);
//		this.x = x;
//		this.y = y;
		this(GameUtil.getImage(imgPath), x, y);//通过this调用另一个构造方法，获取图片地址
	}
}
