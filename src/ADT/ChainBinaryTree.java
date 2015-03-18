package ADT;

import java.util.Scanner;

//CBTType  ��ʽ����������
class CBTType
{
	String data;
	CBTType left;
	CBTType right;
}


public class ChainBinaryTree {
		static final int MAXLEN = 20;
		static Scanner input = new Scanner(System.in);
	//��ʼ��������
	CBTType InitTree()
	{
		CBTType node;
		
		if((node= new CBTType()) != null)    //�����ڴ�
		{
			System.out.println("������һ�����������");
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
	
	//��ӽڵ�
	void addTreeNode(CBTType treeNode)
	{
		CBTType pnode, parent;
		String data;
		int menusel;
		
		if((pnode = new CBTType())!=null)
		{
			System.out.println("����������ڵ�����");
			Scanner input = new Scanner(System.in);
			pnode.data = input.next();
			pnode.left = null;
			pnode.right = null;
			
			
			System.out.print("����ýڵ�ĸ��ڵ�����");
			data=input.next();
			
			parent = TreeFindNode(treeNode,data);
			if(parent == null)
			{
				System.out.println("δ�ҵ����ڵ�");
				pnode = null;
				return;
			}
			
			  System.out.println("1.��Ӹýڵ��������\n2.��Ӹýڵ��������");
			  do
			  {
				  menusel = input.nextInt();
				  
				  if(menusel ==1 ||menusel ==2)
				  {
					  if(parent == null)
					  {
						  System.out.println("�����ڸ��ڵ㣬�������ø��ڵ㣡\n");
					  }
					  else
					  {
						  switch(menusel)
						  {
						  case 1:
							  if(parent.left != null)
							  {
								  System.out.println("��������Ϊ�գ�");
							  }
							  else
							  {
								  parent.left = pnode;
							  }
							  break;
							  
						  case 2:
							  if(parent.right != null)
							  {
								  System.out.println("�������ڵ㲻Ϊ��");
							  }
							  else
							  {
								  parent.right =pnode;
							  }
							  break;
							  default:
								  System.out.println("��Ч������\n");
						  }
					  }
				  }
			  }while(menusel!=1 &&menusel !=2);
		}
	}
	
	//���ҽڵ�
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

	//��ȡ������
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
	
	//��ȡ������
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
	
	//�жϿ���
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
	
	//������������
	 int treeDepth(CBTType treeNode)
	 {
		 int depleft, depright;
		 if(treeNode == null)
		 {
			 return 0;//���ڿ��������Ϊ0��
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
	 
	 //��ն�����
	 void clearTree(CBTType treeNode)
	 {
		 if(treeNode != null)
		 {
			 clearTree(treeNode.left);
			 clearTree(treeNode.right);
			 treeNode =null;
		 }
	 }
	 
	 //��ʾ�ڵ�����
	 void TreeNodeData(CBTType p)
	 {
		 System.out.println(p.data);
	 }
	 
	 //�������
	 void DLRTree(CBTType treeNode)
	 {
		 if(treeNode!=null)
		 {
			 TreeNodeData(treeNode);
			 TreeNodeData(treeNode.left);
			 TreeNodeData(treeNode.right);
		 }
	 }
	 
	 //�������
	 void LDRTree(CBTType treeNode)
	 {
		 if(treeNode != null)
		 {
			 TreeNodeData(treeNode.left);
			 TreeNodeData(treeNode);
			 TreeNodeData(treeNode.right);
		 }
	 }
	 
	 //�������
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
		//���ø�Ԫ��
		root = t.InitTree();
		//��ӽڵ�
		do{
			System.out.println("��ѡ��˵���Ӷ������Ľڵ㣺\n");
			System.out.println("0.�˳�\t");
			System.out.println("1.��Ӷ������Ľڵ�\n");
			menusel = input.nextInt();
			switch(menusel)
			{
				case 1:			//��ӽڵ�
					t.addTreeNode(root);
					break;
				case 0:
					break;
					default:
						;			
			}
		}while(menusel!=0);
		
		//����
		 do{
			 System.out.println("��ѡ��˵�����������������0��ʾ�˳���\n");
			 System.out.println("1.�������DLR\t");//��ʾ�˵�
			 System.out.println("2.�������LDR\n");
			 System.out.println("3.�������LRD\t");
			 menusel=input.nextInt();
			 switch(menusel)
			 {
			 case 0:
				 break;
			 case 1:
				 System.out.println(" �������DLR�Ľ����");
				 t.DLRTree(root);
				 System.out.println("\n");
				 break;
			 case 2:
				 System.out.println("����LDR�����Ľ����");
				 t.LDRTree(root);
				 break;
			 case 3:
				 System.out.println("����LRD�����Ľ����");
				 t.LRDTree(root);
				 break;
				 default:
					 ;
					 
			 
			 }while(menusel != 0);
			 System.out.println("�����������Ϊ:"+t.treeDepth(root));
			 t.clearTree(root);
			 root=null;
				 
		 }
	}
	 	
	 

}
