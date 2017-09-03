package com.xiyou.Sort.HeapSort;

import java.util.*;

public class Heapsort {
	public static HeapNode CreateTree(int[] data,HeapNode root,List<HeapNode> q)
	{
		HeapNode newp;
		int pa = 0;
		for(int i=0;i<data.length;i++)
		{
			if(root == null)
			{
				root =newp = new HeapNode(data[i]);
			}
			else
			{
				newp = new HeapNode(data[i]);
				if(q.get(pa).left == null)
					q.get(pa).left = newp;
				else
				{
					q.get(pa).right = newp;
					pa++;
				}
				
			}
			q.add(newp);
			System.out.print(q.get(i).data+"  ");
		}
		System.out.println();
		return root;
	}
	public static void swap(List<HeapNode> q,HeapNode x,HeapNode y)
	{
		int tmp;
		tmp = x.data;
		x.setdata(y.data);
		y.setdata(tmp);
	}
	public static int BuildBigHeap(HeapNode root,List<HeapNode> q)
	{
		int j,i;
		boolean flag = false;
		for(j=q.size()-1;j>=0 && q.get(j).right ==null && q.get(j).left == null;j--);
		i = j;
		for(;j>=0;j--)
		{
			//System.out.print(q.get(j).data+"  ");
			if(q.get(j).right!=null&&q.get(j).data<q.get(j).right.data){
				//System.out.println(q.get(j).data);
				swap(q,q.get(j),q.get(j).right);
				flag =true;
			}
			if(q.get(j).left!=null&&q.get(j).data<q.get(j).left.data){
				//System.out.println(q.get(j).data);
				swap(q,q.get(j),q.get(j).left);
				flag = true;
			}
		}
		if(i>0 && q.get(i).right != null)
			q.get(i).right = null;
		else
			q.get(i).left =null;
		for(int k=0;k<q.size();k++)
			System.out.print(q.get(k).data+"  ");
		System.out.println();
		return i;
	}
	public static void HeapSort(HeapNode root,List<HeapNode> q)
	{
		int flag;
		while((flag=BuildBigHeap(root,q))>0)
		{
			swap(q,q.get(0),q.get(q.size()-1));
			System.out.println(q.get(q.size()-1).data+"  ");
			q.remove(q.size()-1);
		}
	}
	 //�ݹ��������     
    public static void preorderNoRecursion(HeapNode root) {  
        System.out.print(root.data+"  ");
        if(root.left != null)
        	preorderNoRecursion(root.left);
        if(root.right != null)
        	preorderNoRecursion(root.right);
    }  
	public static void main(String[] args)
	{
		int[] data = new int[]{3,2,5,8,4,7,6,9};
		List<HeapNode> q = new ArrayList<HeapNode>();
		HeapNode root = null;
		root = CreateTree(data,root,q);
//		preorderNoRecursion(root);
		HeapSort(root,q);
//		BuildBigHeap(root,q);
	}
}
