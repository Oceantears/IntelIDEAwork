/**
 * <一句话功能简述>
 * <学生类>
 *
 * @author sunmeng
 * @create 2019/10/14   21:44
 */
package homework20191014;

public class Student {
	private String name;
	private String gender;
	private int age;

	public Student(){

	}

	public Student(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", gender='" + gender + '\'' +
				", age=" + age +
				'}';
	}
}
