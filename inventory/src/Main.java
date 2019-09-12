import inventory.Goods;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sn=new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Goods> goodsList=new ArrayList<Goods>();

        //addGoods(goodsList);
    }

    private static void addGoods(ArrayList<Goods> g){
        System.out.println("向仓库添加物品：");

        int i=0;
        while (true){
            System.out.println("请输入第"+i+"个库存");
            Goods goods=new Goods();
            g.add(goods);
            goods.brand=sn.next();
            goods.size=sn.nextDouble();
            goods.price=sn.nextDouble();
            goods.count=sn.nextInt();
            i++;
        }
    }


    private static int chooseNum(){
        System.out.println("--------------库存管理------------");
        System.out.println("1.查看库存清单；");
        System.out.println("2.修改商品库存数量；");
        System.out.println("3.退出；");
        System.out.println("请输入要执行的操作序号： ");

        int num=sn.nextInt();
        return num;
    }
}
