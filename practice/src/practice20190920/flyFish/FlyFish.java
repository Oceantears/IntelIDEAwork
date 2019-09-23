/**
 * <一句话功能简述>
 * <飞鱼>
 *
 * @author sunmeng
 * @create 2019/9/20   11:26
 */
package practice20190920.flyFish;

public class FlyFish extends Animal implements Flyer,Swiner {

    public FlyFish(){
        super("飞鱼");
    }

    @Override
    public void fly(){
        System.out.println("我会飞~");
    }
    @Override
    public void swim(){
        System.out.println("我会游泳~");
    }
    public void game(){
        FlyFish ff=new FlyFish();
        ff.swim();
        ff.fly();
    }

}
