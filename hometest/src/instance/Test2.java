/**
 * <һ�仰���ܼ���>
 * <���������2>
 *
 * @author sunmeng
 * @create 2019/12/3   17:27
 */
package instance;

public class Test2 implements Itest {
	@Override
	public void hello() {
		System.out.println("�㲻�Ǻܺð�������");
	}

	@Override
	public int findNum(int n) {
		return 1;
	}

	@Override
	public String call() {
		String s1="���ǵڶ��������ࡣ";
		return s1;
	}
}
