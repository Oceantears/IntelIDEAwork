/**
 * <һ�仰���ܼ���>
 * <�����������>
 *
 * @author sunmeng
 * @create 2019/12/3   17:25
 */
package instance;

public class Test1 implements Itest {
	@Override
	public void hello() {
		System.out.println("��ð�������");
	}

	@Override
	public int findNum(int n) {
		return 0;
	}

	@Override
	public String call() {
		String s="���ǵ�һ��������";
		return s;
	}
}
