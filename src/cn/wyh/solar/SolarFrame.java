package cn.wyh.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.wyh.util.Constant;
import cn.wyh.util.GameUtil;
import cn.wyh.util.MyFrame;

/**
 * 太阳系主窗口
 * 绘制所有的图形及轨迹
 * @author wyhpc
 *
 */
public class SolarFrame extends MyFrame {
	
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Star sun = new Star("images/sun.jpg",Constant.xWide/2,Constant.yHeight/2);
	
	Plannet earth = new Plannet(sun,"images/Earth.jpg",100,66,0.01);
	Plannet moon = new Plannet(earth,"images/moon.jpg",20,13,0.05,true);
	
	Plannet mercury = new Plannet(sun,"images/Mercury.jpg",50,33,0.02);
	Plannet venus = new Plannet(sun,"images/Venus.jpg",70,46,0.015);
	
	Plannet mars = new Plannet(sun,"images/Mars.jpg",150,100,0.008);
	Plannet jupiter = new Plannet(sun,"images/Jupiter.jpg",250,166,0.005);
	Plannet saturn = new Plannet(sun,"images/Saturn.jpg",300,200,0.004);
	Plannet uranus = new Plannet(sun,"images/Uranus.jpg",350,233,0.003);
	Plannet neptune = new Plannet(sun,"images/Neptune.jpg",400,266,0.002);
	
	public void paint(Graphics g) {
		
		//画背景
		g.drawImage(bg, 0, 0, null);
		
		//画图形
		sun.draw(g);
		
		earth.draw(g);
		moon.draw(g);
		
		mercury.draw(g);
		venus.draw(g);
		mars.draw(g);
		jupiter.draw(g);
		saturn.draw(g);
		uranus.draw(g);
		neptune.draw(g);
	}

	//主函数
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
}
