package com.ultimate.basicalo.exhaustive;

import java.util.Scanner;

/**
 * 
 * @author malaoer
 * @Desciption 穷举算法：  鸡兔同笼
 * @data 2019/3/31
 * @version 1.0
 */
public class ChickenAndRabbitCage {
	static int chicken,rabbit;
	public static void main(String args[]) {
		int re,head,foot;
		System.out.println("求解鸡兔同笼问题");
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入头数：");
		head = scan.nextInt();
		System.out.println("请输入脚数");
		foot = scan.nextInt();
		re = qiongju(head,foot);
		if(re == 1) {
			System.out.printf("鸡有%d,兔有%d只.",chicken,rabbit);
		}else {
			System.out.println("不存在解");
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
