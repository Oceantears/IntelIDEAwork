/**
 * <一句话功能简述>
 * <反射测试用类>
 *
 * @author sunmeng
 * @create 2019/12/3   17:25
 */
package instance;

public class Test1 implements Itest {
	@Override
	public void hello() {
		System.out.println("你好啊！！！");
	}

	@Override
	public int findNum(int n) {
		return 0;
	}

	@Override
	public String call() {
		String s="这是第一个测试类";
		return s;
	}
}
