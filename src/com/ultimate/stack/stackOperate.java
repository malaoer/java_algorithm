package com.ultimate.stack;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Description 栈的基本操作
 * @data 2019/3/29
 * @version 1.0
 */

public class stackOperate {
	public static void main(String args[]) {
		StackType s = new StackType();
		DATA3 data = new DATA3();
		StackType stack = s.STInit();
		Scanner scan = new Scanner(System.in);
		System.out.println("输入姓名 年龄进行入栈操作");
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
		System.out.println("出栈操作：按任意非0键进行出栈操作");
		temp = scan.next();
		while(!temp.equals("0")) {
			data=s.popStack(stack);
			System.out.printf("出栈的元素为：(%s,%d)\n",data.name,data.age);
			if (s.IsEmpty(stack)) {
				System.out.println("栈空");
				break;
			}
			temp = scan.next();
			
		}
		System.out.println("测试结束");
		s.release(stack);
	}

}

class DATA3{
	/*
	 * 	定义栈中元素的数据类型
	 */
	String name;
	int age;
}

class StackType{
	
	static final int MAXLEN = 50;
	DATA3[] data = new DATA3[MAXLEN+1];	  		//数据元素
	int top;
	
	public StackType STInit() {
		/**
		 * 栈的初始化
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
		 * 栈空
		 */
		if(s.top==0) {
			return true;
		}
		return false;
	}
	
	public boolean IsFull(StackType s) {
		/**
		 * 栈满
		 */
		if (s.top == MAXLEN) {
			return true;
		}
		return false;
	}
	
	public void clearStack(StackType s) {
		/**
		 * 清空栈
		 */
		s.top = 0;
	}
	
	public void release(StackType s) {
		/**
		 * 释放栈所占用的空间
		 */
		if(s.top != 0) {
			s = null;
		}	
	}
	
	public void pushStack(StackType s,DATA3 data) {
		/**
		 * 入栈操作
		 */
		if (s.top!=MAXLEN) {
			s.data[++s.top] = data;
		}else {
			System.out.println("栈满");
		}
	}
	
	public DATA3 popStack(StackType s) {
		/**
		 * 出栈操作
		 */
		if(s.top==0) {
			System.out.println("栈为空！\n");
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
