package leetCode;

public class TwoSum {
    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
    public int[] twoSum(int[] nums,int target){
        int[] count=new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]==target-nums[i]){
                    count[0]=i;
                    count[1]=j;
                    return count;         //加上这句，返回第一对值；注销这句，返回最后一对值
                }
            }
        }
        return count;
    }

    //    public void console(int[] nums,int target){
//        System.out.println(twoSum(nums,target)[0]+"\t"+twoSum(nums,target)[1]);
//    }
}
