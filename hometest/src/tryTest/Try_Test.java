/**
 * <一句话功能简述>
 * <try_catch测试>
 *
 * @author sunmeng
 * @create 2019/12/6   17:08
 */
package tryTest;

public class Try_Test {
	public static void main(String[] args) {

		System.out.println(num(1));
	}
	public static int num(int x){

		try {
			//x=x+1;
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			x=x+1;
			return x;
		}
	}
}

