/**
 * <一句话功能简述>
 * <p>
 * 单例模式中进行双重加锁
 * 双重检查加锁不适用于1.4及更早版本的JAVA。
 *
 * @author sunmeng
 * @create 2019/12/27   11:12
 */
package singleton;

public class Singleton {
	private volatile static Singleton uniqueInstance;	//volatile关键词确保：当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地处理uniqueInstance变量。
	private Singleton(){}
	public static Singleton getInstance(){
		if(uniqueInstance==null){			//检查实例，如果不存在，就进入同步区块
			synchronized (Singleton.class){
				if(uniqueInstance==null){				//进入区块后，再检查一次，如果仍为null，才创建实例
					uniqueInstance=new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
}
