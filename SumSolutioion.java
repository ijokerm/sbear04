package niuke;

import java.util.Scanner;

public class SumSolutioion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int result1=Sum1(n);
        int result2=Sum1(n*n);
        System.out.println(result1+" "+result2);
    }
    public static int Sum1(int n){
        while(n<0){
            return -1;
        }
        int count=0;
        if(n>0){
           for(int i=n;i>0;i=i/10){
               count+=i%10;
           }
        }
        return count;
    }
}
