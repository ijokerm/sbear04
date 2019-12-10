package niuke;

public class Gift {
    public static int getValue(int[]gifts,int n){
       //数组排序思路
        int[]temp=sort(gifts);
        n=temp.length/2;
        for(int i=0;i<temp.length;i++){
           if(temp[i]>n){
               return temp[i];
           }
        }
     return 0;
    }
    public static int[] sort(int[] gifts){
        for(int i=0;i<gifts.length;i++){
            for(int j=0;j<i;j++){
                if(gifts[j]>gifts[j+1]){
                    int t=gifts[j];
                    gifts[j]=gifts[j+1];
                    gifts[j+1]=t;
                }
            }
        }
        return gifts;
    }

    public static void main(String[] args) {

    }
}
