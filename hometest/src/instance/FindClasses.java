/**
 * <一句话功能简述>
 *
 * <这个程序可以分析 Java 解释器能够加载的任何类， 而不仅仅是编译程序时可以使用的类。>
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
		//从命令行或者输入获取类名
		String name;
		if(args.length>0){
			name=args[0];
		}else {
			Scanner in=new Scanner(System.in);
			System.out.println("请输入一个类的名字：");
			name=in.next();
			in.nextLine();         //防止Scanner类的bug
		}

		//如果父类不是Object，输入类和其父类
		try {
			Class cl=Class.forName(name);
			Class supercl=cl.getSuperclass();
			String modifiers= Modifier.toString(cl.getModifiers());   //getModifiers()将返回一个整型数值，用不同的位开关描述 public 和 static 这样的修饰符使用状况

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

	//打印所有构造函数
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
	//打印所有方法
	public static void printMethods(Class cl){

	}
	//打印所有域
	public static void printFields(Class cl){

	}
}
