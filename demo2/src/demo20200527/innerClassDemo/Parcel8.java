/**
 * <一句话功能简述>
 * <p>
 * 需要一个有参数的构造器的基类
 *
 * @author sunmeng
 * @create 2020/5/27   11:23
 */
package demo20200527.innerClassDemo;

public class Parcel8 {
	public Wrapping wrapping(int x){
		return new Wrapping(x){
			public int value(){
				return super.value()*47;
			}
		};
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();

		Wrapping w = p.wrapping(10);
		System.out.println("============w.value()================="+w.value());
	}
}
class Wrapping{
	private int i;
	public Wrapping(int x){
		i=x;
	}
	public int value(){
		System.out.println("Wrapping类"+i);
		return i;
	}
}
