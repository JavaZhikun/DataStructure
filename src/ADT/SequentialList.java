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
	
	//��ʼ�����б�
	void SLInit(SLType SL)
	{
		SL.ListLen = 0;
	}
	
	//�������б��Ԫ������
	int SLLength(SLType SL)
	{
		return(SL.ListLen);
	}
	
	//����ڵ�
	int SLInsert(SLType SL,int n,DATA data)
	{
		int i;
		//���Ƚ�����ȷ������ų���
		if(SL.ListLen >= MAXLEN)
		{
			System.out.println("˳������������ܲ���ڵ�");
			return 0;
		}
		if(n<1 || n>SL.ListLen - 1) //����ڵ㲻��ȷ
		{
			System.out.println("����Ԫ����Ŵ��󣬲��ܲ���Ԫ�ء�\n");
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
	
	//ɾ���ڵ�
	int SLDelete(SLType SL,int n)
	{
		if(n<1 || n>SL.ListLen)
		{
			System.out.println("�˴��޽ڵ㣬ɾ��λ�ò���ȷ");
			return 0;
		}
		for()
	}
}





public class SequentialList {

}
