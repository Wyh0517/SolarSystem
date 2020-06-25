package cn.wyh.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.wyh.util.GameUtil;

/**
 * ������Ϊ������
 * ����ͼƬ�����ƺ��ǵ�λ��
 * @author wyhpc
 *
 */
public class Star {
	Image img;	//ͼƬ
	double x,y;	//����
	int width,height;	//ͼƬ��С
	Star star;	//Star����
	
	public void draw(Graphics g) {
		//������
		g.drawImage(img, (int)x, (int)y, null);		
	}
	
	public Star() {}	//����Ŀչ�����

	//���ع�����
	public Star(Image img) {
		this.img = img;					//����ͼƬ
		this.width = img.getWidth(null);	//��ȡͼƬ�߶�
		this.height = img.getHeight(null);	//��ȡͼƬ���
	}
	
	//���ع�����
	public Star(Image img, double x, double y) {
		this(img);
		this.x = x;		//������
		this.y = y;		//������
	}
	
	//���ع����������ڴ���
	public Star(String imgPath, double x, double y) {
//		this.img = GameUtil.getImage(imgPath);
//		this.x = x;
//		this.y = y;
		this(GameUtil.getImage(imgPath), x, y);//ͨ��this������һ�����췽������ȡͼƬ��ַ
	}
}
