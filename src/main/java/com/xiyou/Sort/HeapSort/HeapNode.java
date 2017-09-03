package com.xiyou.Sort.HeapSort;

public class HeapNode {
	public int data;
	public HeapNode left = null;
	public HeapNode right = null;
	public HeapNode(int data)
	{
		this.data= data;
	}
	public void setdata(int data)
	{
		this.data = data;
	}
	public void setleft(HeapNode left)
	{
		this.left= left;
	}
	public void setright(HeapNode right)
	{
		this.right = right;
	}
}
