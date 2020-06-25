package cn.wyh.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.wyh.util.GameUtil;

/**
 * 行星行为及属性
 * 加载图片，控制行星的坐标及运行
 * @author wyhpc
 *
 */
public class Plannet extends Star {

	//除了图片，坐标。行星沿着椭圆运行：长轴，短轴，速度，绕着Star飞
	double longAxis;	//椭圆的半长轴
	double shortAxis;	//椭圆的半短轴
	double speed;	//飞行角速度
	double degree;	//与轴的夹角
	Star center;	//Star对象
	
	boolean satellite;	//判断是否是卫星
	
	public void draw(Graphics g) {
	
		//画椭圆轨迹				
		if(satellite) {
			boolean s = satellite;
			drawTrace(g, s);
		}else
			drawTrace(g);
		
		//画星星
//		g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		
		//沿着椭圆轨迹飞行
		move();
	}
	
	public void drawTrace(Graphics g) {
		//画椭圆轨迹
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;		//椭圆的长轴
		ovalHeight = shortAxis*2;	//椭圆的短轴
		ovalX = (center.x + center.width/2) - longAxis;	//椭圆的位置
		ovalY = (center.y + center.height/2) - shortAxis;
		
		Color c = g.getColor();		//获取之前的颜色
		g.setColor(Color.blue);		//换颜色
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);		//改回之前的颜色	
	}
	//重载方法，卫星轨迹单独设置
	public void drawTrace(Graphics g,boolean s) {
		//画椭圆轨迹
		double ovalX = 0,ovalY = 0,ovalWidth = 0,ovalHeight = 0;	
		this.drawTrace(g);
		
		Color c = g.getColor();		//获取之前的颜色
		g.setColor(Color.white);		//换颜色
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);		//改回之前的颜色	
	}
	
	public void move() {
		//沿着椭圆轨迹飞行
		x = (center.x + center.width/2 - width/2) + longAxis*Math.cos(degree);	//x=x0+a*cosA
		y = (center.y + center.height/2 - height/2) + shortAxis*Math.sin(degree);	//y=y0+b*sinA
				
		degree += speed;
	}
	
	//重载构造器
	public Plannet(Star center, String imgPath, double longAxis, 
			double shortAxis, double speed) {
		
		super(GameUtil.getImage(imgPath));		//通过super调用父类构造方法，获取图片地址
		
		this.center = center;			//获取父类的属性
		this.x = center.x + longAxis;	//坐标
		this.y = center.y;
		
		this.longAxis = longAxis;		//椭圆的半长轴
		this.shortAxis = shortAxis;		//椭圆的半短轴
		this.speed = speed;				//速度
		
		this.width = img.getWidth(null);		//获取图片大小
		this.height = img.getHeight(null);
	}
	
	//重载构造器，加卫星属性
	public Plannet(Star center, String imgPath, double longAxis, 
			double shortAxis, double speed, boolean satellite) {
		
		this(center, imgPath, longAxis, shortAxis, speed);
		this.satellite = satellite;
	}

//	public Plannet(Image img, double x, double y) {
//		super(img, x, y);
//	}
//	
//	public Plannet(String imgPath, double x, double y) {
//		super(imgPath, x, y);
//	}

}
