package com.ultimate.list;

import java.util.Scanner;
/**
 * 
 * @author malaoer
 * @Description ˳���Ļ�������
 * @data 2019/4/1
 * @version 1.0
 */

public class sequentiaList {
	public static void main(String args[]) {
		int i;
		SLType sl = new SLType();
		DATA1 data;
		String key;
		System.out.println("˳����еĲ�����");
		sl.SLInit(sl);
		System.out.println("��ʼ����ɣ�");
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("����Ҫ��ӵĽڵ㣨ѧ�� ���� ���䣩");
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
		
//		System.out.println("˳����еĽڵ�˳��Ϊ��");
//		sl.SLALL(sl);
//		System.out.println("Ҫȡ���Ľڵ�����Ϊ");
//		i = scan.nextInt();
//		data = sl.SLSearchByNum(sl,i);
//		if(data!=null) {
//			System.out.printf("(%s,%s,%d)\n",data.key,data.name,data.age);
//		}
//		
//		System.out.println("Ҫ���ҵĽڵ�Ĺؼ���");
//		key= scan.next();
//		data = sl.SLSearchByKey(sl, key);
//		if(data!=null) {
//			System.out.printf("(%s,%s,%d)\n",data.key,data.name,data.age);
//		}
//		System.out.println("Ҫɾ���ڵ�����Ϊ��");
//		i= scan.nextInt();
//		System.out.println(sl.SLDelete(sl, i));
		
		System.out.println("Ҫ����Ľڵ�");
		data = new DATA1();
		data.key = scan.next();
		data.name = scan.next();
		data.age = scan.nextInt();
		System.out.println("����Ҫλ��");
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
	int listlen;		//˳������Ѵ�ڵ������
	
	public void SLInit(SLType sl) {
		//��ʼ��
		sl.listlen = 0;
	}
	
	public int SLLen(SLType sl) {
		//˳���ĳ���
		return (sl.listlen);
	}
	
	public int  SLInsert(SLType sl,int n,DATA1 data) {
		//����ڵ�
		if (sl.listlen >= LISTLEN) {
			System.out.println("˳����������޷�����");
			return 0;
		}
		if(n<0 || n> sl.listlen) {
			System.out.println("�������Ŵ����޷�����");
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
		//��ĩβ׷��Ԫ��
		if(sl.listlen >= LISTLEN) {
			System.out.println("˳����������޷�׷��");
			return 0;
		}else {
			sl.data[sl.listlen] = data;
			sl.listlen ++;
			
			return 1;
		}
		
	}

	public int SLDelete(SLType sl,int n) {
		if(n<0 || n>sl.listlen) {
			System.out.println("ɾ��Ԫ�ص���Ŵ����޷�ɾ��");
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
			System.out.println("����Ԫ�ص����������޷�����");
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