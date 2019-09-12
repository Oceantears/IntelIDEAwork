import leetCode.TwoSum;

public class Main {
    public static void main(String[] args) {
        //第一题         (不能直接打印数组，出来的是地址！！！！)
        int[] nums=new int[]{2,3,4,5,6,7,8};
        int target=9;
        TwoSum ts=new TwoSum();
        int[] temp = ts.twoSum(nums,target);
        for(int i:temp){
            System.out.println(i);
        }


    }
}
