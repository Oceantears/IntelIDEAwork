/**
 * <一句话功能简述>
 * <吱吱吱叫类>
 *
 * @author sunmeng
 * @create 2019/12/8   19:20
 */
package ducks;

public class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("吱吱吱！！！！");
	}
}
