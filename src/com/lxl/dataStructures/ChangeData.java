package com.lxl.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ChangeData {
	public static Object[] List2Array(List<Object> oList) {   
        Object[] oArray = oList.toArray(new Object[] {});   
        // TODO ��Ҫ���õ���ʱ������д��������֧�ַ��͵�Array.   
        return oArray;   
    }   
  
    public static Object[] Set2Array(Set<Object> oSet) {   
        Object[] oArray = oSet.toArray(new Object[] {});   
        // TODO ��Ҫ���õ���ʱ������д��������֧�ַ��͵�Array.   
        return oArray;   
    }   
  
    public static <T extends Object> List<T> Set2List(Set<T> oSet) {   
        List<T> tList = new ArrayList<T>(oSet);   
        // TODO ��Ҫ���õ���ʱ������д���죬������Ҫ����List�Ķ�Ӧ���ࡣ   
        return tList;   
    }   
  
    public static <T extends Object> List<T> Array2List(T[] tArray) {   
        List<T> tList = Arrays.asList(tArray);   
        // TODO ������asList()���ص�tList�޷�add(),remove(),clear()��һЩӰ�켯�ϸ����Ĳ�����   
        // ��ΪArrays$ArrayList��java.util.ArrayListһ�������Ǽ̳�AbstractList��   
        // ����Arrays$ArrayListû��override��Щ��������java.util.ArrayListʵ���ˡ�   
        // TODO ����ʹ��List�����������أ�������Arrays$ArrayList��������Ҫ�ɡ�������ע��:   
        // List<T> tList = new ArrayList<T>(Arrays.asList(tArray));   
        return tList;   
    }   
  
    public static <T extends Object> Set<T> List2Set(List<T> tList) {   
        Set<T> tSet = new HashSet<T>(tList);   
        //TODO ����ʵ�ֿ�����ת���ɲ�ͬ��Set�����ࡣ   
        return tSet;   
    }   
  
    public static <T extends Object> Set<T> Array2Set(T[] tArray) {   
        Set<T> tSet = new HashSet<T>(Arrays.asList(tArray));   
        // TODO û��һ����λ�ķ��������ݾ�������ã�ѡ����ʵ�Set��������ת����   
        return tSet;   
    } 
    
    
    public static void main(String[] orgs){
    	char[] c = {'a','b','c'};
    	List ls = new ArrayList(Arrays.asList(c));
    	Iterator i1 = ls.iterator();
    	while(i1.hasNext()){
    		System.out.println(i1.next().toString());
    	}
    	Object[] str =  ls.toArray();
    	System.out.println(str[0]);
    	List ls2 = Arrays.asList(str);
    	Iterator i2 = ls2.iterator();
    	while(i2.hasNext()){
    		System.out.println(i2.next().toString());
    	}
    	Set set = new HashSet(ls2);
    	Iterator i3 = set.iterator();
    	while(i3.hasNext()){
    		System.out.println(i3.next().toString());
    	}
    	List ls3 = Arrays.asList(set);
    	Iterator i = set.iterator();
    	while(i.hasNext()){
    		System.out.println(i.next().toString());
    	}
    	
    }
}