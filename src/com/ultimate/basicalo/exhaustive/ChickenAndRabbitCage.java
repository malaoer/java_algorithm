package com.ultimate.basicalo.exhaustive;

import java.util.Scanner;

/**
 * 
 * @author malaoer
 * @Desciption ����㷨��  ����ͬ��
 * @data 2019/3/31
 * @version 1.0
 */
public class ChickenAndRabbitCage {
	static int chicken,rabbit;
	public static void main(String args[]) {
		int re,head,foot;
		System.out.println("��⼦��ͬ������");
		Scanner scan = new Scanner(System.in);
		System.out.println("������ͷ����");
		head = scan.nextInt();
		System.out.println("���������");
		foot = scan.nextInt();
		re = qiongju(head,foot);
		if(re == 1) {
			System.out.printf("����%d,����%dֻ.",chicken,rabbit);
		}else {
			System.out.println("�����ڽ�");
		}
	}
	
	public static int qiongju(int head,int foot) {
		int re,x,y;
		re = 0;
		for(x=0;x<head;x++) {
			y =head -x;
			if(2*x+4*y == foot) {
				re = 1;
				chicken = x;
				rabbit = y;
				
			}
		}
		return re;
	}
}
