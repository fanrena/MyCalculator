//*�ż�1702 ѧ�ţ�2017005587 
// * �����
// * 2019.05.25
// * �汾1.00.00
// * û����һ���汾�˴��
// * .....................................................
// *.....................................................
// *.....................................................
// *..,]]]]]]..........]]]OOOOO]\]`......................
// * /@@@@@@@@@O\]/OOOO[[............\OOO].,O@@@@@@@@O....
// *@@@@@@@@@@@O/`.......................\O@@@@@@@@@@@^..
// *@@@@@@@@@@/.............................O@@@@@@@@@O..
// *@@@@@@@@@^...............................O@@@@@@@@@^.
// *@@@@@@@O..................................\@@@@@@@@^.
// *@@@@@@^.....................,]]]...........O@@@@@@O..
// *\@@@@O............,]]OO]....O@@@@@O^........O@@@@/...
// *...\O^.........O@@@@@@@@O^.*o/...............O/......
// *...=^.........*\[`..,ooOO/...\O@@O...........=O......
// *../O...........*/O@@@O`........,*.............O^.....
// *..O/...............*..........................=O.....
// *.=O...................,]*......./OO`..........=O.....
// *=O..................,OOOOOOOOOOO`,OOO^.........OO`...
// *@@^...............]OOo*.,[oOOOo]\/]`*..........O@@@O`
// *@@^.............*\\OOOOOOOOOO/[`=O/............O@@@@@
// *@@O`................=O[OOO]]`**\O[............=@@@@@@
// *@@@@O...............*\\..[*..................,O@@@@@@
// *@@@@@O`..............****,OOOOOOo*.........,O@@@@@@@@
// *@@@@@@@@O\...................*.........../@@@@@@@@@@@
// *@@@@@@@@@@@\].......................]/O@@@@@@@@@@@@@@
// *@@@@@@@@@@@@@@@@OOO]]]]]]]]]]/OOO@@@@@@@@@@@@@@@@@@@@
// *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// *@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@O@OOOOOOO
// */
package MyCalculator;

//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;

//import javax.swing.JDialog;
//import javax.swing.JFrame;

public class ToolBox {
	public static String final_result="null";//�ַ����������ս��
	public static double result=0;//���
	public static double  temp=0;//+-
	public static double temp_1=1;//*/
	public static double temp_2=1;//no use
	private static int se_counnt=0;//no use
	public static int ch_count=0;//no use
	public static int con=0;//С����С�����ִ���
	public static int statue=1;//С�����������ִ���
	public static String syb_1="+";//��¼��һ��+-��
	public static String syb_2="*";//��¼��һ��*/��
	public static String ch="null";
	public static String origin="null";//ԭʼ�ַ�����ʽ�ӣ�����仯һ��һ���ѵ�����
	public static String replace="null";//�滻ԭʽ�е����ţ���������
	public static void calculate(String ch_temp)//���㲿�֣��������޶���
	{
		ch=ch_temp;
		switch(ch)
		{
		/*
		 * ��Ŀ�������ʽ{result=��Ŀ��������;con=0;statue=0;break;}
		 * ˫Ŀ�������ʽ{temp_1=˫Ŀ��������;temp=���������ǲ�������İɣ�temp_1�Ǻ�* /ͬ���ȼ�
		 * temp��+-ͬ���ȼ���syb_2��/*ͬ���ȼ���syb_1�Ǻ�+-ͬ���ȼ�
		 * �ƺ���Ū��temp_2��syb_3������^�ٸ�һ�����ȼ��ˣ��������ø���
		 * 
		 * 
		 * 
		 */
		case("1"):{result=result*(Math.pow(10, statue))+1*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("2"):{result=result*(Math.pow(10, statue))+2*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("3"):{result=result*(Math.pow(10, statue))+3*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("4"):{result=result*(Math.pow(10, statue))+4*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("5"):{result=result*(Math.pow(10, statue))+5*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("6"):{result=result*(Math.pow(10, statue))+6*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("7"):{result=result*(Math.pow(10, statue))+7*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("8"):{result=result*(Math.pow(10, statue))+8*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("9"):{result=result*(Math.pow(10, statue))+9*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("0"):{result=result*(Math.pow(10, statue))+0*(Math.pow(10,con));if(con<0) {con--;}se_counnt=0;break;}
		case("."):{con=-1;statue=0;break;}
		case("+"):
		{
			if(se_counnt==0)
			{result=mark(syb_2);negetive();temp=mark("+");syb_1="+";syb_2="*";se_counnt++;result=0;temp_1=1;con=0;statue=1;break;}
			else{syb_1="+";result=0;con=0;statue=0;se_counnt++;break;}
		}
		case("-"):
		{
			if(se_counnt==0)
			{result=mark(syb_2);negetive();temp=mark("+");syb_1="-";result=0;se_counnt++;/*syb_2="*";*/temp_1=1;con=0;statue=1;break;}
			else{syb_1="-";result=0;con=0;statue=0;se_counnt++;break;}
		}
		case("*"):{negetive();temp_1=mark(syb_2);syb_2="*";syb_1="+";se_counnt++;result=0;con=0;statue=1;break;}
		case("/"):{negetive();temp_1=mark(syb_2);syb_2="/";syb_1="+";se_counnt++;result=0;con=0;statue=1;break;}
		case("="):{result=mark(syb_2);negetive();temp=mark("+");syb_1="+";syb_2="*";se_counnt=0;result=0;temp_1=1;result=temp;statue=1;con=0;break;}//��ʵ���Ǹ�+
		case("c"):{result=Math.cos(result);con=0;statue=1;break;}//cos
		case("s"):{result=Math.sin(result);con=0;statue=1;break;}//sin
		case("t"):{result=Math.abs(result);con=0;statue=1;break;}//tan
		case("^"):{temp_1=mark(syb_2);syb_2="^";result=0;con=0;statue=1;break;}//pow��a��b�������ȶ���˳�ͬ�������ø���
		//case("C"):{initialize();final_result="null";break;}//����
		case("��"):{result=0-result;con=0;statue=0;break;}
		case("f"):{result=1/result;con=0;statue=0;break;}
		case("m"):{negetive();temp_1=mark(syb_2);syb_2="m";se_counnt++;result=0;con=0;statue=1;break;}
		}
	}
	private static void show() {System.out.println("runned");}//�����û�õ��ĺ�������
	public static void negetive()
	{
		//System.out.println("result"+result+syb_1);
		if(syb_1.equals("-"))
			result=0-result;
		//System.out.println("Late/result"+result);
	}
	public static void initialize()//��������ʼ��
	{
		result=0;
		temp=0;
		temp_1=1;
		syb_1="+";
		syb_2="*";
		con=0;
		se_counnt=0;
		ch_count=0;
		ch="null";
		statue=1;
	}
	public static void String_initialize()
	{
		final_result="null";
	}
	public static double mark(String a)//������һ������������㣬a+b+����a+b��ֵ֮���
	{
		double noname=0;
		//negetive();
		switch(a)
		{
		case("+"):{noname=result+temp;break;}
		//case("-"):{noname=temp+(0-result);break;}
		case("*"):{noname=result*temp_1;break;}
		case("/"):{noname=temp_1/result;break;}
		case("^"):{noname=Math.pow(temp_1, result);break;}
		case("m"):{noname=temp_1%result;break;}
		default:{System.out.println(a);}
		}
		//System.out.println("noname="+noname);
		return noname;//���
	}
	public static void String_Handler(String a)
	{
		int total=0;
		int b_total=0;
		int front=0;
		int	back=0;
		String re="null";
		String or="null";
		origin=a;
		for(int i=0;i<origin.length();i++)
		{
			if(a.charAt(i)=='(')
				total++;
			if(a.charAt(i)==')')
				b_total++;
		}
		if(total!=b_total) {
			//JDialog error=new JDialog(error, "����ɶԵ����Ű�kora");
			String_Saver.switcher("C");
		}
		//System.out.println("total="+total);
		
		while(total!=0) 
		{
			label:for(int i=0;i<origin.length();i++)
			{
				if(origin.charAt(i)==('('))
				{
					front=i;
					//System.out.println("front="+front);
				}
				else if(origin.charAt(i)==(')'))
				{
					back=i;
					//System.out.println("back="+back);
					break label;
				}
			}
			re=origin.substring(front+1,back);
			//System.out.println("re="+re);
			or=origin.substring(front,back+1);
			//System.out.println("or="+or);
			replace=String_(re);
			origin=origin.replace(or,replace);
			origin=origin.replace("--", "+");
			origin=origin.replace("-+", "-");
			origin=origin.replace("+-", "-");
			//System.out.println("origin="+origin);
			total--;
			front=0;
			back=0;
		}
		if(total==0)
		{
			origin=origin.replace("--", "+");
			origin=origin.replace("-+", "-");
			origin=origin.replace("+-", "-");
			//System.out.println(origin);
			final_result=String_(origin);
		}
	}
	public static String String_(String a)
	{
		if(a.charAt(a.length()-1)!='=')
			a=a+"=";
		initialize();
		for(int i=0;i<a.length();i++)
		{
			calculate(String.valueOf(a.charAt(i)));
		}
		//System.out.println("replace="+result);
		//System.out.println("replace="+Integer.toString((int)result));
		if(result%1==0)
		{
			return Integer.toString((int)result);
		}
		else
			return Double.toString(result);
	}
}

