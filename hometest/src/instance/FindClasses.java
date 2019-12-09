/**
 * <һ�仰���ܼ���>
 *
 * <���������Է��� Java �������ܹ����ص��κ��࣬ ���������Ǳ������ʱ����ʹ�õ��ࡣ>
 *  This program uses reflection to print all features of a class.
 *
 * @author sunmeng
 * @create 2019/12/4   11:09
 */
package instance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class FindClasses {
	public static void main(String[] args) {
		//�������л��������ȡ����
		String name;
		if(args.length>0){
			name=args[0];
		}else {
			Scanner in=new Scanner(System.in);
			System.out.println("������һ��������֣�");
			name=in.next();
			in.nextLine();         //��ֹScanner���bug
		}

		//������಻��Object����������丸��
		try {
			Class cl=Class.forName(name);
			Class supercl=cl.getSuperclass();
			String modifiers= Modifier.toString(cl.getModifiers());   //getModifiers()������һ��������ֵ���ò�ͬ��λ�������� public �� static ���������η�ʹ��״��

			if(modifiers.length()>0){
				System.out.print(modifiers+" ");

			}
			System.out.print("class "+name);
			if(supercl!=null&&supercl!=Object.class){
				System.out.print(" extends "+supercl.getName());
			}
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFields(cl);
			System.out.println("}");


		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.exit(0);
	}

	//��ӡ���й��캯��
	public static void printConstructors(Class cl){
		Constructor[] constructors=cl.getDeclaredConstructors();
		for(Constructor con:constructors){
			String name=con.getName();
			System.out.print("	");
			String modifiers=Modifier.toString(con.getModifiers());
			if(modifiers.length()>0){
				System.out.print(modifiers+" ");
			}
			System.out.print(name+"(");
			// print parameter types
			Class[] paramTypes=con.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++){
				if(j>0){
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}

	}
	//��ӡ���з���
	public static void printMethods(Class cl){

	}
	//��ӡ������
	public static void printFields(Class cl){

	}
}
