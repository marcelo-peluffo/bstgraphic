package com.marcelo;

import java.util.*;
import static java.lang.System.*;

@SuppressWarnings("unchecked")

public class BinarySearchTree
{
	private BinaryNode root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public BinaryNode getRoot()
	{
		return root;
	}
	
	public void setRoot(BinaryNode x)
	{
		root = x;
	}
	
	public void add(BinaryNode x)
	{
		if(root ==  null)
		{
			root = x;
			return;
		}
		add(root, x);
	}
	
	protected void add(BinaryNode parent, BinaryNode x)
	{
		if(parent==null) return;
		if(parent.getValue().compareTo(x.getValue())>0)
			if(parent.left()==null)
				parent.setLeft(x);
			else
				add(parent.left(),x);
		else
			if(parent.right()==null)
				parent.setRight(x);
			else
				add(parent.right(), x);
		
		
	}
	
	public String toString()
	{	return inOrder(root);	}
	
	public String inOrder()
	{	return inOrder(root);	}
	
	protected String inOrder(BinaryNode k)
	{
		String temp = "";
		if(k!=null)
		{
			temp += inOrder(k.left());
			temp += k.getValue()+" ";
			temp += inOrder(k.right());
		}
		
		return temp;
	}
	
	public String preOrder()
	{	return preOrder(root);	}
	
	private String preOrder(BinaryNode k)
	{
		String temp = "";
		if(k!=null)
		{
			temp += k.getValue()+" ";
			temp += preOrder(k.left());
			temp += preOrder(k.right());
		}
		
		return temp;
	}
	
	public String postOrder()
	{	return postOrder(root);	}
	
	private String postOrder(BinaryNode k)
	{
		String temp = "";
		if(k!=null)
		{
			temp += postOrder(k.left());
			temp += postOrder(k.right());
			temp += k.getValue()+" ";
		}
		
		return temp;
	}
	
	public String reverseOrder()
	{	return reverseOrder(root);	}
	
	private String reverseOrder(BinaryNode k)
	{
		String temp = "";
		if(k!=null)
		{
			temp += reverseOrder(k.right());
			temp += k.getValue()+" ";
			temp += reverseOrder(k.left());
		}
		
		return temp;
	}
	
	public int getNumLeaves()
	{
		if (root==null) return 0;
		return getNumLeaves(root);
	}
	
	private int getNumLeaves(BinaryNode k)
	{
		if(k==null)
			return 0;
		if(k.left()==null && k.right()==null)
			return 1;
		return getNumLeaves(k.left())+getNumLeaves(k.right());
	}
	
	public int getNumLevels()
	{
		if(root==null) return 0;
		return getNumLevels(root);
	}
	
	private int getNumLevels(BinaryNode k)
	{
		if (k==null)
			return 0;
		return 1+Math.max(getNumLevels(k.left()), getNumLevels(k.right()));
	}
	
	public int getWidth()
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		
		int maxSize = 1;
				
		queue.add(root);
		while(!queue.isEmpty())
		{
			int size = queue.size();
			if(maxSize < size)
				maxSize = size;
			while(size > 0)
			{
				BinaryNode k = queue.remove();
				if(k.left()!=null)
					queue.add(k.left());
				if(k.right()!=null)
					queue.add(k.right());
				size--;
			}
		}
		
		return maxSize;
	}
	
	public int getWidthAtLevel(int level)
	{
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		int width = 0;
		queue.add(root);
		while(!queue.isEmpty())
		{
			int size = queue.size();
			if(width == level)
				return size;
			width++;
			while(size > 0)
			{
				BinaryNode k = queue.remove();
				if(k.left()!=null)
					queue.add(k.left());
				if(k.right()!=null)
					queue.add(k.right());
				size--;
			}
		}
		
		return 0;
	}
	
	public int diameter()
	{
		if(root == null) return 0;
		return 1 + getNumLevels(root.right())+getNumLevels(root.left());
	}
	
	public int getHeight()
	{
		return getNumLevels()-1;
	}
	
	public int getNumNodes()
	{
		return getNumNodes(root);
	}
	
	private int getNumNodes(BinaryNode k)
	{
		if(k!=null)
			return getNumNodes(k.left())+getNumNodes(k.right())+1;
		return 0;
	}
	
	public boolean isFull()
	{
		int level = getNumLevels();
		int nodes = getNumNodes();
		return nodes == Math.pow(2, level)-1;
	}
	
	public boolean contains(Comparable x)
	{
		return contains(root, x);
	}
	
	private boolean contains(BinaryNode k, Comparable x)
	{
		if(k==null) return false;
		if(k.getValue().equals(x)) return true;
		if(x.compareTo(k.getValue())<0)
			return contains(k.left(), x);
		else
			return contains(k.right(), x);
	}
	
	public Comparable getLargest()
	{
		if(root==null)
			return Integer.MIN_VALUE;
		return getLargest(root);
	}
	
	private Comparable getLargest(BinaryNode k)
	{
		if(k.right()!=null)
			return getLargest(k.right());
		return k.getValue();
	}
	
	public Comparable getSmallest()
	{
		if(root==null)
			return Integer.MAX_VALUE;
		return getSmallest(root);
	}
	
	private Comparable getSmallest(BinaryNode k)
	{
		if(k.left()!=null)
			return getSmallest(k.left());
		return k.getValue();
	}
	
	public String levelOrder()
	{
		if(root==null)
			return null;
		Queue<Comparable> queue = new LinkedList<Comparable>();
		levelOrder(queue, root);
		return queue.toString();
	}
	
	public Queue<Comparable> fullLevelOrder()
	{
		if(root==null)
			return null;
		Queue<Comparable> queue = new LinkedList<Comparable>();
		fullLevelOrder(queue, root);
		return queue;
	}
	
	public void printFullTree(Queue<Comparable>queue, int numLevels)
	{
		if(queue == null) return;
		String str = "";
		for(int i=0; i<numLevels; i++)
		{
			
			for(int j=1; j<=Math.pow(2,i); j++)
				str+=queue.poll()+"|";
			str = str.substring(0,str.length()-1);
			str+="\n";			
		}
		str = str.substring(0,str.length()-1);
		str = str.replace("null","--");
		out.println(str);
	}
	
	private void levelOrder(Queue<Comparable> queue, BinaryNode k)
	{
		Queue<BinaryNode> treeQueue = new LinkedList<BinaryNode>();
		treeQueue.offer(k);
		while(!treeQueue.isEmpty())
		{
			//out.println(treeQueue);
			BinaryNode temp = treeQueue.poll();
			queue.offer(temp.getValue());
			if(temp.left()!=null)
				treeQueue.offer(temp.left());
			if(temp.right()!=null)
				treeQueue.offer(temp.right());
		}		
	}
	
	public boolean queueIsAllNull(Queue<BinaryNode> treeQueue)
	{
		
		int length = treeQueue.size();
		boolean isEmpty = true;
		while(length>0)
		{
			
			if(treeQueue.peek()!=null)
				isEmpty = false;
			treeQueue.offer(treeQueue.poll());
			length--;
		}
		
		return isEmpty;
	}
	
	private void fullLevelOrder(Queue<Comparable> queue, BinaryNode k)
	{
		
		Queue<BinaryNode> treeQueue = new LinkedList<BinaryNode>();
		treeQueue.offer(k);
		int count = 0;
		while(!queueIsAllNull(treeQueue)&&count<Math.pow(2, 6)-1)
		{
			count++;
			BinaryNode temp = treeQueue.poll();
			if(temp==null)
			{
				queue.offer(null);
				treeQueue.offer(null);
				treeQueue.offer(null);
			}
			else
			{
				queue.offer(temp.getValue());
				treeQueue.offer(temp.left());
				treeQueue.offer(temp.right());
			}
		}		
		
	}

	protected BinaryNode successor(BinaryNode k)
	{
		BinaryNode temp = k;
		temp = temp.right();
		while(temp.left()!=null)
			temp = temp.left();
		return temp;
	}
	
	protected void swap(BinaryNode x, BinaryNode y)
	{
		Comparable k = x.getValue();
		x.setValue(y.getValue());
		y.setValue(k);
	}
	
	protected BinaryNode search(BinaryNode parent, Comparable target)
	{
		if(parent==null) return null;
		if(parent.left()!=null && parent.left().getValue().equals(target)||
		   parent.right()!=null && parent.right().getValue().equals(target))
			return parent;
		else if(target.compareTo(parent.getValue())<0)
			return search(parent.left(),target);
		else
			return search(parent.right(),target);
			
	}
	
	public BinaryNode remove(Comparable target)
	{
		if(root==null) return null;
		BinaryNode temp = root;
		BinaryNode inorderSuccessor;
		
		if(root.getValue().equals(target))
		{
			if(root.left()==null && root.right()==null)
			{
				root=null;
				return null;
			}
			else if(root.left()==null)
			{
				root = root.right();
				temp.setRight(null);
				return temp;
			}
			else if(root.right()==null)
			{
				root = root.left();
				temp.setLeft(null);
				return temp;
			}
			else
			{
				inorderSuccessor = successor(root);
				swap(root,inorderSuccessor);
				if(root.right()==inorderSuccessor)
				{
					root.setRight(inorderSuccessor.right());
					inorderSuccessor.setRight(null);
					return inorderSuccessor;
				}
				return remove(root.right(),target);
			}	
		}
		return remove(root,target);
	}
	
	public BinaryNode remove(BinaryNode startNode, Comparable target) {return null;}
	
}

