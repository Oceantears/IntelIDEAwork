/**
 * <一句话功能简述>
 * <飞鱼游戏类>
 *2.开发一个Flyer接口(飞行者)，要求如下：
 * 1)  定义一个飞行方法：void fly();
 * 开发一个Swimer接口（游泳者），要求如下：
 * 2)  一个游泳方法：void swim();
 * 开发一个FlyFish类（飞鱼）要求如下：
 * 1)	该类为非抽象类；
 * 2)	继承Animal类；
 * 3)	实现Flyer接口和Swimer接口；
 * 4)	定义一个公有的（public）无参构造方法，该构造方法通过调用父类的构造方法为父类属性name赋值“飞鱼”。
 * 5)	定义一个公有的实例方法，其功能为玩游戏：public void game(){//...}
 * 开发一个测试类如下，进行测试。
 * @author sunmeng
 * @create 2019/9/20   11:23
 */
package practice20190920.flyFish;

public class FlyGame {
    public static void main(String[] args) {
        FlyFish ff=new FlyFish();
        System.out.println("我的名字是："+ff.getName());
        ff.game();
    }

}
