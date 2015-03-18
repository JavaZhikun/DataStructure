package ADT;

import java.util.Scanner;

//CBTType  链式二叉树类型
class CBTType
{
	String data;
	CBTType left;
	CBTType right;
}


public class ChainBinaryTree {
		static final int MAXLEN = 20;
		static Scanner input = new Scanner(System.in);
	//初始化二叉树
	CBTType InitTree()
	{
		CBTType node;
		
		if((node= new CBTType()) != null)    //申请内存
		{
			System.out.println("请输入一个根结点数据");
			Scanner input = new Scanner(System.in);
			node.data = input.next();
			node.left = null;
			node.right = null;
			if(node != null)
			{
				return node;
			}
			else 
			{
				return null;
			}
		}
		return null;
		
	}
	
	//添加节点
	void addTreeNode(CBTType treeNode)
	{
		CBTType pnode, parent;
		String data;
		int menusel;
		
		if((pnode = new CBTType())!=null)
		{
			System.out.println("输入二叉树节点数据");
			Scanner input = new Scanner(System.in);
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			
			System.out.print("输入该节点的父节点数据");
			data=input.next();
			
			parent = TreeFindNode(treeNode,data);
			if(parent == null)
			{
				System.out.println("未找到父节点");
				pnode = null;
				return;
			}
			
			  System.out.println("1.添加该节点的左子树\n2.添加该节点的右子树");
			  do
			  {
				  menusel = input.nextInt();
				  
				  if(menusel ==1 ||menusel ==2)
				  {
					  if(parent == null)
					  {
						  System.out.println("不存在父节点，请先设置父节点！\n");
					  }
					  else
					  {
						  switch(menusel)
						  {
						  case 1:
							  if(parent.left != null)
							  {
								  System.out.println("左子树不为空！");
							  }
							  else
							  {
								  parent.left = pnode;
							  }
							  break;
							  
						  case 2:
							  if(parent.right != null)
							  {
								  System.out.println("右子树节点不为空");
							  }
							  else
							  {
								  parent.right =pnode;
							  }
							  break;
							  default:
								  System.out.println("无效参数！\n");
						  }
					  }
				  }
			  }while(menusel!=1 &&menusel !=2);
		}
	}
	
	//查找节点
	CBTType TreeFindNode(CBTType treeNode, String data)
	{
		CBTType ptr;
		
		if(treeNode == null)
		{
			return null;
		}
		else
		{
			if(treeNode.data.equals(data))
			{
				return treeNode;
			}
			else
			{
				if((ptr=TreeFindNode(treeNode.left,data))!=null)
				{
					return ptr;
				}
				else if((ptr=TreeFindNode(treeNode.right,data))!=null)
				{
					return ptr;
				}
				else 
				{
					return null;
				}
			}
		}
		
	}

	//获取左子树
	CBTType TreeLeftNode(CBTType treeNode)
	{
		if(treeNode!=null)
		{
			return treeNode.left;
		}
		else
		{
			return null;
		}
	}
	
	//获取右子树
	CBTType TreeRightNode(CBTType treeNode)
	{
		if(treeNode!=null)
		{
			return treeNode.right;
		}
		else
		{
			return null;
		}
	}
	
	//判断空树
	int TreeIsEmpty(CBTType treeNode)
	{
		if(treeNode!=null)
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
	
	//计算二叉树深度
	 int treeDepth(CBTType treeNode)
	 {
		 int depleft, depright;
		 if(treeNode == null)
		 {
			 return 0;//对于空树，深度为0；
		 }
		 else
		 {
			 depleft = treeDepth(treeNode.left);
			 depright = treeDepth(treeNode.right);
			 if(depleft > depright)
			 {
				 return depleft + 1;
			 }
			 else
			 {
				 return depright + 1;
			 }
		 }
	 }
	 
	 //清空二叉树
	 void clearTree(CBTType treeNode)
	 {
		 if(treeNode != null)
		 {
			 clearTree(treeNode.left);
			 clearTree(treeNode.right);
			 treeNode =null;
		 }
	 }
	 
	 //显示节点数据
	 void TreeNodeData(CBTType p)
	 {
		 System.out.println(p.data);
	 }
	 
	 //先序遍历
	 void DLRTree(CBTType treeNode)
	 {
		 if(treeNode!=null)
		 {
			 TreeNodeData(treeNode);
			 TreeNodeData(treeNode.left);
			 TreeNodeData(treeNode.right);
		 }
	 }
	 
	 //中序遍历
	 void LDRTree(CBTType treeNode)
	 {
		 if(treeNode != null)
		 {
			 TreeNodeData(treeNode.left);
			 TreeNodeData(treeNode);
			 TreeNodeData(treeNode.right);
		 }
	 }
	 
	 //后序遍历
	 void LRDTree(CBTType treeNode)
	 {
		 if(treeNode != null)
		 {
			 TreeNodeData(treeNode.left);
			 TreeNodeData(treeNode.right);
			 TreeNodeData(treeNode);
		 }
	 }
	 
	 public static void main(String[] args) {
		CBTType root = null;
		int menusel;
		ChainBinaryTree t= new ChainBinaryTree();
		//设置跟元素
		root = t.InitTree();
		//添加节点
		do{
			System.out.println("请选择菜单添加二叉树的节点：\n");
			System.out.println("0.退出\t");
			System.out.println("1.添加二叉树的节点\n");
			menusel = input.nextInt();
			switch(menusel)
			{
				case 1:			//添加节点
					t.addTreeNode(root);
					break;
				case 0:
					break;
					default:
						;			
			}
		}while(menusel!=0);
		
		//遍历
		 do{
			 System.out.println("请选择菜单遍历二叉树，输入0表示退出：\n");
			 System.out.println("1.先序遍历DLR\t");//显示菜单
			 System.out.println("2.中序遍历LDR\n");
			 System.out.println("3.后序遍历LRD\t");
			 menusel=input.nextInt();
			 switch(menusel)
			 {
			 case 0:
				 break;
			 case 1:
				 System.out.println(" 先序遍历DLR的结果：");
				 t.DLRTree(root);
				 System.out.println("\n");
				 break;
			 case 2:
				 System.out.println("中序LDR遍历的结果：");
				 t.LDRTree(root);
				 break;
			 case 3:
				 System.out.println("后序LRD遍历的结果：");
				 t.LRDTree(root);
				 break;
				 default:
					 ;
					 
			 
			 }while(menusel != 0);
			 System.out.println("二叉树的深度为:"+t.treeDepth(root));
			 t.clearTree(root);
			 root=null;
				 
		 }
	}
	 	
	 

}
