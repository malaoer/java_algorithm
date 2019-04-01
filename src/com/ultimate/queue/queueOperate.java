package com.ultimate.queue;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Desription ���еĻ�������
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
		System.out.println("��Ӳ�����");
		System.out.println("�������� ���������Ӳ���:");
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
		System.out.println("���Բ������������0�����г��Բ���");
		temp = scan.next();
		while(!temp.equals("0")) {
			if (!qt.IsEmpty(stack)){
				data1 = qt.outQueue(stack);
				System.out.printf("�����е�����Ϊ��%s,%d\n",data1.name,data1.age);
				temp = scan.next();
			}else {
				System.out.println("����Ϊ�գ�");
				break;
			}
		}
		System.out.println("���Խ���");
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
			System.out.println("��������");
		}
	}
	
	public DATA4 outQueue(QueueType qt) {
		if(qt.head == qt.tail) {
			System.out.println("����Ϊ��");
			System.exit(0);
		}else {
			return qt.data[qt.head++];
		}
		return null;
	}
	
	public DATA4 peekQueue(QueueType qt) {
		if(IsEmpty(qt)) {
			System.out.println("����Ϊ��");
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