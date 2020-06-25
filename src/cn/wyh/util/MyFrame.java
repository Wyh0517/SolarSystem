package cn.wyh.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 定义及加载窗口的类
 * 封装，作为以后窗口的共同父类
 * @author wyhpc
 *
 */
public class MyFrame extends Frame {		// GUI编程：AWT，swing等
	
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		setSize(Constant.xWide,Constant.yHeight);
		setLocation(Constant.xLoc,Constant.yLoc);
		setVisible(true);//设置为可见
		
		new PaintThread().start();//启动重画线程
		
		//点击关闭监听
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}		
		});
	}
	
	public MyFrame() {
		
	}
	
	/**
	 * 定义一个重画窗口的线程类，是一个内部类
	 * @author wyhpc
	 *
	 */
	class PaintThread extends Thread{	//绘图线程类
		
		public void run() {		//重写方法
			while(true) {
				repaint();	//外部类方法
				try {
					Thread.sleep(25);	//1s=1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Image offScreenImage = null; 
	public void update(Graphics g){
		if (offScreenImage == null){
			offScreenImage = this.createImage(Constant.xWide,Constant.yHeight); 
		}
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
}
