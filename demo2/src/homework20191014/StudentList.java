/**
 * <一句话功能简述>
 *
 * <1.用代码实现以下需求
 * 	(1)定义学生类,包含姓名(String name),性别(String gender),年龄(int age)三个属性,生成空参有参构造,set和get方法,toString方法
 * 	(2)键盘录入6个学员信息(录入格式:张三,男,25),要求有两个相同的信息,将6个学员信息存入到ArrayList集合中
 * 	(3)将存有6个学员信息的ArrayList集合对象写入到D:\\StudentInfo.txt文件中
 * 	(4)读取D:\\StudentInfo.txt文件中的ArrayList对象
 * 	(5)对ArrayList集合中的6个学生对象进行去重并按照年龄从小到大的顺序排序
 * 	(6)将ArrayList集合中排序后的结果利用PrintWriter流写入到E:\\StudentInfo.txt文件中(写入格式：张三-男-25)>
 *
 * @author sunmeng
 * @create 2019/10/14   21:48
 */
package homework20191014;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
	public static void main(String[] args) {
		ArrayList<Student> stuList=new ArrayList<>();
		getStudent(stuList);
		for(Student stu:stuList){
			System.out.println(stu.toString());
		}

		//将存有6个学员信息的ArrayList集合对象写入到D:\\StudentInfo.txt文件中

	}

	//接收输入的学生信息
	public static ArrayList<Student> getStudent(ArrayList<Student> students){
		Scanner scanner=new Scanner(System.in);
		int i=1;                     //输入学生个数
		while (true){
			Student student=new Student();
			System.out.println("请输入第"+i+"个学生的姓名：");
			student.setName(scanner.nextLine());

			System.out.println("请输入第"+i+"个学生的性别：");
			student.setGender(scanner.nextLine());

			System.out.println("请输入第"+i+"个学生的年龄：");
			student.setAge(scanner.nextInt());
			scanner.nextLine();                   //填充整行


			students.add(student);
			i++;
			if(i>6){
				break;
			}
		}
		return students;
	}
}
