/**
 * <һ�仰���ܼ���>
 *
 * <���ڷ������ϰ>
 *
 * @author sunmeng
 * @create 2019/12/3   14:06
 */
package instance;

public class Instance_test {

	public static void main(String[] args) {
		//��ȡ���ڵķ���
		// try {
		// 	Method[] methods =Class.forName("java_base.Int_test").getMethods();
		// 	for (Method meth:methods) {
		// 		System.out.println(meth.getName());
		// 	}
		// } catch (ClassNotFoundException e) {
		// 	e.printStackTrace();
		// }


		//newInstance()�����޲��������������һ����ʵ��
		//newInstanceʵ�����ǰ�new�����ʽ�ֽ�Ϊ����,�������ȵ���class�ļ��ط�������ĳ���࣬Ȼ��ʵ������
		//      �����ֲ��ĺô����Զ��׼��ġ����ǿ����ڵ���class�ľ�̬���ط���forNameʱ��ø��õ�����ԣ��ṩ�������ǽ�����ֶΡ�
		Class claz= null;
		// try {
		// 	claz = Class.forName("instance.Test2");         //��ȡMouse��
		// 	Itest itest=(Itest) claz.newInstance();					//ʵ����Mouse��ĸ�����߽ӿڵ��޲ι���ʵ��
		// 	itest.hello();
		// 	System.out.println(itest.call());
		// } catch (ClassNotFoundException e) {
		// 	e.printStackTrace();
		// } catch (IllegalAccessException e) {
		// 	e.printStackTrace();
		// } catch (InstantiationException e) {
		// 	e.printStackTrace();
		// }


		Itest itest=new Test1();
		Class cl=itest.getClass();
		System.out.println(itest.getClass().getName());


		//���棺 ������ʷԭ getName ������Ӧ�����������͵�ʱ��᷵��һ������ֵ�����
		System.out.println(Double[].class.getName());
		System.out.println(int[].class.getName());
		System.out.println(char[].class.getName());



	}
}
