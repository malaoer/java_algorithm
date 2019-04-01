package com.ultimate.stack;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Description ջ�Ļ�������
 * @data 2019/3/29
 * @version 1.0
 */

public class stackOperate {
	public static void main(String args[]) {
		StackType s = new StackType();
		DATA3 data = new DATA3();
		StackType stack = s.STInit();
		Scanner scan = new Scanner(System.in);
		System.out.println("�������� ���������ջ����");
		do {
			DATA3 data1= new DATA3();
			data1.name=scan.next();
			if (data1.name.equals("0")) {
				break;
			}else {
				data1.age=scan.nextInt();
				s.pushStack(stack, data1);
			}
		}while(true);
		String temp = "1";
		System.out.println("��ջ�������������0�����г�ջ����");
		temp = scan.next();
		while(!temp.equals("0")) {
			data=s.popStack(stack);
			System.out.printf("��ջ��Ԫ��Ϊ��(%s,%d)\n",data.name,data.age);
			if (s.IsEmpty(stack)) {
				System.out.println("ջ��");
				break;
			}
			temp = scan.next();
			
		}
		System.out.println("���Խ���");
		s.release(stack);
	}

}

class DATA3{
	/*
	 * 	����ջ��Ԫ�ص���������
	 */
	String name;
	int age;
}

class StackType{
	
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN+1];	  		//����Ԫ��
	int top;
	
	public StackType STInit() {
		/**
		 * ջ�ĳ�ʼ��
		 */
		StackType p;
		if ((p = new StackType())!=null) {
			p.top = 0;
			return p;
		}
		return null;
	}
	
	public boolean IsEmpty(StackType s) {
		/**
		 * ջ��
		 */
		if(s.top==0) {
			return true;
		}
		return false;
	}
	
	public boolean IsFull(StackType s) {
		/**
		 * ջ��
		 */
		if (s.top == MAXLEN) {
			return true;
		}
		return false;
	}
	
	public void clearStack(StackType s) {
		/**
		 * ���ջ
		 */
		s.top = 0;
	}
	
	public void release(StackType s) {
		/**
		 * �ͷ�ջ��ռ�õĿռ�
		 */
		if(s.top != 0) {
			s = null;
		}	
	}
	
	public void pushStack(StackType s,DATA3 data) {
		/**
		 * ��ջ����
		 */
		if (s.top!=MAXLEN) {
			s.data[++s.top] = data;
		}else {
			System.out.println("ջ��");
		}
	}
	
	public DATA3 popStack(StackType s) {
		/**
		 * ��ջ����
		 */
		if(s.top==0) {
			System.out.println("ջΪ�գ�\n");
			System.exit(0);
		}
		return s.data[s.top--];
	}
	
	public DATA3 readTop(StackType s) {
		if (s.top!=0) {
			return s.data[s.top];
		}
		return null;
	}
	
	
}
