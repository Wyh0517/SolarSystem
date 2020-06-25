package cn.wyh.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.wyh.util.GameUtil;

/**
 * ������Ϊ������
 * ����ͼƬ���������ǵ����꼰����
 * @author wyhpc
 *
 */
public class Plannet extends Star {

	//����ͼƬ�����ꡣ����������Բ���У����ᣬ���ᣬ�ٶȣ�����Star��
	double longAxis;	//��Բ�İ볤��
	double shortAxis;	//��Բ�İ����
	double speed;	//���н��ٶ�
	double degree;	//����ļн�
	Star center;	//Star����
	
	boolean satellite;	//�ж��Ƿ�������
	
	public void draw(Graphics g) {
	
		//����Բ�켣				
		if(satellite) {
			boolean s = satellite;
			drawTrace(g, s);
		}else
			drawTrace(g);
		
		//������
//		g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		
		//������Բ�켣����
		move();
	}
	
	public void drawTrace(Graphics g) {
		//����Բ�켣
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;		//��Բ�ĳ���
		ovalHeight = shortAxis*2;	//��Բ�Ķ���
		ovalX = (center.x + center.width/2) - longAxis;	//��Բ��λ��
		ovalY = (center.y + center.height/2) - shortAxis;
		
		Color c = g.getColor();		//��ȡ֮ǰ����ɫ
		g.setColor(Color.blue);		//����ɫ
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);		//�Ļ�֮ǰ����ɫ	
	}
	//���ط��������ǹ켣��������
	public void drawTrace(Graphics g,boolean s) {
		//����Բ�켣
		double ovalX = 0,ovalY = 0,ovalWidth = 0,ovalHeight = 0;	
		this.drawTrace(g);
		
		Color c = g.getColor();		//��ȡ֮ǰ����ɫ
		g.setColor(Color.white);		//����ɫ
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);		//�Ļ�֮ǰ����ɫ	
	}
	
	public void move() {
		//������Բ�켣����
		x = (center.x + center.width/2 - width/2) + longAxis*Math.cos(degree);	//x=x0+a*cosA
		y = (center.y + center.height/2 - height/2) + shortAxis*Math.sin(degree);	//y=y0+b*sinA
				
		degree += speed;
	}
	
	//���ع�����
	public Plannet(Star center, String imgPath, double longAxis, 
			double shortAxis, double speed) {
		
		super(GameUtil.getImage(imgPath));		//ͨ��super���ø��๹�췽������ȡͼƬ��ַ
		
		this.center = center;			//��ȡ���������
		this.x = center.x + longAxis;	//����
		this.y = center.y;
		
		this.longAxis = longAxis;		//��Բ�İ볤��
		this.shortAxis = shortAxis;		//��Բ�İ����
		this.speed = speed;				//�ٶ�
		
		this.width = img.getWidth(null);		//��ȡͼƬ��С
		this.height = img.getHeight(null);
	}
	
	//���ع�����������������
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
