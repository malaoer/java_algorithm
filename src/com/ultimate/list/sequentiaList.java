package com.ultimate.list;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Description 顺序表的基本操作
 * @data 2019/4/1
 * @version 1.0
 */

public class sequentiaList {
	public static void main(String args[]) {
		int i;
		SLType sl = new SLType();
		DATA1 data;
		String key;
		System.out.println("顺序表中的操作：");
		sl.SLInit(sl);
		System.out.println("初始化完成！");
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("输入要添加的节点（学号 姓名 年龄）");
			DATA1 data1 =new DATA1();
			data1.key = scan.next();
			data1.name = scan.next();
			data1.age = scan.nextInt();
			if(data1.age != 0) {
				if(sl.SLAdd(sl, data1)==0) {
					break;
				}
			}else {
				break;
			}
			
		}while(true);
		
//		System.out.println("顺序表中的节点顺序为：");
//		sl.SLALL(sl);
//		System.out.println("要取出的节点的序号为");
//		i = scan.nextInt();
//		data = sl.SLSearchByNum(sl,i);
//		if(data!=null) {
//			System.out.printf("(%s,%s,%d)\n",data.key,data.name,data.age);
//		}
//		
//		System.out.println("要查找的节点的关键字");
//		key= scan.next();
//		data = sl.SLSearchByKey(sl, key);
//		if(data!=null) {
//			System.out.printf("(%s,%s,%d)\n",data.key,data.name,data.age);
//		}
//		System.out.println("要删除节点的序号为：");
//		i= scan.nextInt();
//		System.out.println(sl.SLDelete(sl, i));
		
		System.out.println("要插入的节点");
		data = new DATA1();
		data.key = scan.next();
		data.name = scan.next();
		data.age = scan.nextInt();
		System.out.println("插入要位置");
		i =scan.nextInt();
		System.out.println(sl.SLInsert(sl, i, data));
		sl.SLALL(sl);
		
		
		
	}

}

class DATA1{
	String key;
	String name;
	int age;
}

class SLType{
	
	static final int LISTLEN = 100;
	DATA1[] data = new DATA1[LISTLEN]; 
	int listlen;		//顺序表中已存节点的数量
	
	public void SLInit(SLType sl) {
		//初始化
		sl.listlen = 0;
	}
	
	public int SLLen(SLType sl) {
		//顺序表的长度
		return (sl.listlen);
	}
	
	public int  SLInsert(SLType sl,int n,DATA1 data) {
		//插入节点
		if (sl.listlen >= LISTLEN) {
			System.out.println("顺序表已满，无法插入");
			return 0;
		}
		if(n<0 || n> sl.listlen) {
			System.out.println("插入的序号错误，无法插入");
			return 0;
		}
		for (int i=sl.listlen;i>=n;i--) {
			sl.data[i] = sl.data[i-1];
		}
		sl.data[n-1] = data;
		sl.listlen++;
		return 1;			
	}
	
	public int SLAdd(SLType sl,DATA1 data) {
		//在末尾追加元素
		if(sl.listlen >= LISTLEN) {
			System.out.println("顺序表已满，无法追加");
			return 0;
		}else {
			sl.data[sl.listlen] = data;
			sl.listlen ++;
			
			return 1;
		}
		
	}

	public int SLDelete(SLType sl,int n) {
		if(n<0 || n>sl.listlen) {
			System.out.println("删除元素的序号错误，无法删除");
			return 0;
		}
		for(int i = n-1;i<sl.listlen-1;i++) {
			sl.data[i] = sl.data[i+1];
		}
		sl.listlen --;
		
		return 1;
	}
	
	public DATA1 SLSearchByNum(SLType sl,int n) {
		if(n<0 || n>sl.listlen-1) {
			System.out.println("查找元素的索引错误，无法查找");
			return null;
		}
		return sl.data[n-1];
		
	}
	public DATA1 SLSearchByKey(SLType sl,String key) {
		for(int i =0;i<sl.listlen;i++) {
			if(sl.data[i].key.compareTo(key) == 0) {
				return sl.data[i];
			}
		}
		return null;
	}
	public void SLALL(SLType sl) {
		for(int i=0;i<sl.listlen;i++) {
			System.out.printf("(%s,%s,%d)\n",sl.data[i].key,sl.data[i].name,sl.data[i].age);
		}
	}
}