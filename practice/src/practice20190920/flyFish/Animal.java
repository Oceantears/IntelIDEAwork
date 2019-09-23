/**
 * <一句话功能简述>
 * <Animal类>
 *
 * @author sunmeng
 * @create 2019/9/20   11:26
 */
package practice20190920.flyFish;

public abstract class Animal {
    public String getName() {
        return name;
    }

    private String name;
    public Animal(){ }
    public Animal(String name){
        this.name=name;
    }
}
