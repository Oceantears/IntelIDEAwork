/**
 * <一句话功能简述>
 * <反射测试类2>
 *
 * @author sunmeng
 * @create 2019/12/3   17:27
 */
package instance;

public class Test2 implements Itest {
	@Override
	public void hello() {
		System.out.println("你不是很好啊！！！");
	}

	@Override
	public int findNum(int n) {
		return 1;
	}

	@Override
	public String call() {
		String s1="这是第二个测试类。";
		return s1;
	}
}
