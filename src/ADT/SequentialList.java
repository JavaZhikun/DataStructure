package ADT;

class DATA
{
	String key;
	String name;
	int age;
}

class SLType
{
	static final int MAXLEN = 100;
	DATA[] ListData = new DATA[MAXLEN+1];
	int ListLen;
	
	//初始化序列表
	void SLInit(SLType SL)
	{
		SL.ListLen = 0;
	}
	
	//返回序列表的元素数量
	int SLLength(SLType SL)
	{
		return(SL.ListLen);
	}
	
	//插入节点
	int SLInsert(SLType SL,int n,DATA data)
	{
		int i;
		//首先将不正确的情况排除掉
		if(SL.ListLen >= MAXLEN)
		{
			System.out.println("顺序表已满，不能插入节点");
			return 0;
		}
		if(n<1 || n>SL.ListLen - 1) //插入节点不正确
		{
			System.out.println("插入元素序号错误，不能插入元素。\n");
			return 0;
		}
		for(i=SL.ListLen; i>=n; i--)
		{
			SL.ListData[i+1] = SL.ListData[i];	
		}
		
		SL.ListData[i] = data;
		SL.ListLen++;
		return 0;
	}
	
	//删除节点
	int SLDelete(SLType SL,int n)
	{
		if(n<1 || n>SL.ListLen)
		{
			System.out.println("此处无节点，删除位置不正确");
			return 0;
		}
		for()
	}
}





public class SequentialList {

}
