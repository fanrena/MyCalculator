
// * 南欧以南
// * 2019.05.25
// * 版本1.00.00
// * 没有下一个版本了大概
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
	public static String final_result="null";//字符串化的最终结果
	public static double result=0;//结果
	public static double  temp=0;//+-
	public static double temp_1=1;//*/
	public static double temp_2=1;//no use
	private static int se_counnt=0;//no use
	public static int ch_count=0;//no use
	public static int con=0;//小数点小数部分处理
	public static int statue=1;//小数点整数部分处理
	public static String syb_1="+";//记录上一个+-号
	public static String syb_2="*";//记录上一个*/号
	public static String ch="null";
	public static String origin="null";//原始字符串（式子），会变化一步一步脱掉括号
	public static String replace="null";//替换原式中的括号，从内往外
	public static void calculate(String ch_temp)//计算部分，无括号限定。
	{
		ch=ch_temp;
		switch(ch)
		{
		/*
		 * 单目运算符格式{result=单目运算内容;con=0;statue=0;break;}
		 * 双目运算符格式{temp_1=双目运算内容;temp=。。。还是参照下面的吧，temp_1是和* /同优先级
		 * temp和+-同优先级，syb_2是/*同优先级，syb_1是和+-同优先级
		 * 似乎再弄个temp_2和syb_3就能让^再高一个优先级了，不过懒得改了
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
		case("="):{result=mark(syb_2);negetive();temp=mark("+");syb_1="+";syb_2="*";se_counnt=0;result=0;temp_1=1;result=temp;statue=1;con=0;break;}//其实就是个+
		case("c"):{result=Math.cos(result);con=0;statue=1;break;}//cos
		case("s"):{result=Math.sin(result);con=0;statue=1;break;}//sin
		case("t"):{result=Math.abs(result);con=0;statue=1;break;}//tan
		case("^"):{temp_1=mark(syb_2);syb_2="^";result=0;con=0;statue=1;break;}//pow（a，b），优先度与乘除同级，懒得改了
		//case("C"):{initialize();final_result="null";break;}//归零
		case("±"):{result=0-result;con=0;statue=0;break;}
		case("f"):{result=1/result;con=0;statue=0;break;}
		case("m"):{negetive();temp_1=mark(syb_2);syb_2="m";se_counnt++;result=0;con=0;statue=1;break;}
		}
	}
	private static void show() {System.out.println("runned");}//检查用没用到的函数。。
	public static void negetive()
	{
		//System.out.println("result"+result+syb_1);
		if(syb_1.equals("-"))
			result=0-result;
		//System.out.println("Late/result"+result);
	}
	public static void initialize()//计算器初始化
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
	public static double mark(String a)//进行上一个运算符的运算，a+b+，算a+b的值之类的
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
		return noname;//结果
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
			//JDialog error=new JDialog(error, "输入成对的括号啊kora");
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

