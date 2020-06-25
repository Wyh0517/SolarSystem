package cn.wyh.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���弰���ش��ڵ���
 * ��װ����Ϊ�Ժ󴰿ڵĹ�ͬ����
 * @author wyhpc
 *
 */
public class MyFrame extends Frame {		// GUI��̣�AWT��swing��
	
	/**
	 * ���ش���
	 */
	public void launchFrame() {
		setSize(Constant.xWide,Constant.yHeight);
		setLocation(Constant.xLoc,Constant.yLoc);
		setVisible(true);//����Ϊ�ɼ�
		
		new PaintThread().start();//�����ػ��߳�
		
		//����رռ���
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
	 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
	 * @author wyhpc
	 *
	 */
	class PaintThread extends Thread{	//��ͼ�߳���
		
		public void run() {		//��д����
			while(true) {
				repaint();	//�ⲿ�෽��
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
