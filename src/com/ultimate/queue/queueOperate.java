package com.ultimate.queue;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Desription 队列的基本操作
 * @data 2019/3/31
 * @version 1.0
 *
 */

public class queueOperate {
	public static void main(String args[]) {
		QueueType qt =new QueueType();
		DATA4 data1;
		Scanner scan = new Scanner(System.in);
		QueueType stack =qt.initQueue();
		System.out.println("入队操作：");
		System.out.println("输入姓名 年龄进行入队操作:");
		do {
			DATA4 data = new DATA4();
			data.name = scan.next();
			data.age = scan.nextInt();
			if(data.name.equals("0")) {
				break;
			}else {
				qt.InQueue(stack,data);
			}
		}while(true);
		
		String temp = "1";
		System.out.println("出对操作：按任意非0键进行出对操作");
		temp = scan.next();
		while(!temp.equals("0")) {
			if (!qt.IsEmpty(stack)){
				data1 = qt.outQueue(stack);
				System.out.printf("出队列的数据为：%s,%d\n",data1.name,data1.age);
				temp = scan.next();
			}else {
				System.out.println("队列为空：");
				break;
			}
		}
		System.out.println("测试结束");
		qt.freeQueue(stack);
	}

}

class DATA4 {
	String name;
	int age;
}

class QueueType{
	static final int QUEUELEN=50;
	DATA4[] data = new DATA4[QUEUELEN];
	int head;
	int tail;
	
	public QueueType initQueue() {
		QueueType qt;
		if((qt =new QueueType())!=null) {
			qt.head = 0;
			qt.tail = 0;
			return qt;
		}else {
			return null;
		}
		
	}
	
	public boolean IsEmpty(QueueType qt) {
		boolean temp = false;
		if(qt.head==qt.tail) {
			temp =true;
		}
		return temp;
	}
	
	public boolean IsFull(QueueType qt) {
		boolean temp = false;
		if(qt.tail==QUEUELEN) {
			temp = true;
		}
		return temp;
	}
	
	public void clearQueue(QueueType qt) {
		qt.head = 0;
		qt.tail = 0;
				
	}
	
	public void freeQueue(QueueType qt) {
		if(qt != null) {
			qt =null;
		}
	}
	public void InQueue(QueueType qt,DATA4 data) {
		if(qt.tail != QUEUELEN) {
			qt.data[qt.tail++] = data;
		}else {
			System.out.println("队列已满");
		}
	}
	
	public DATA4 outQueue(QueueType qt) {
		if(qt.head == qt.tail) {
			System.out.println("队列为空");
			System.exit(0);
		}else {
			return qt.data[qt.head++];
		}
		return null;
	}
	
	public DATA4 peekQueue(QueueType qt) {
		if(IsEmpty(qt)) {
			System.out.println("队列为空");
		}else {
			return qt.data[qt.head];
		}
		return null;
		
	}
	
	public int queueLen(QueueType qt) {
		int temp;
		temp = qt.tail - qt.head;
		return temp;	
	}
}