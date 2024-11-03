import java.util.Arrays;

public class test {

    public int pairSum(int[]nums, int target){
        int i=0,j=nums.length-1;
        while(i<j){
            int ps = nums[i]+nums[j];
            if(ps>target){
                j--;
            }
            else if(ps<target){
                i++;
            }
            else{
                return ps;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
     int nums[] = {2,7,11,15};
     int target = 15;
     test Test = new test();
     System.out.println(Test.pairSum(nums,target));
     
    }
}
