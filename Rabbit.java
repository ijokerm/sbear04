package niuke;

import java.util.Scanner;

public class Rabbit {
    public static int getNum(int mouth){
        if(mouth<3){
            return 1;
        }
        return getNum(mouth-1)+getNum(mouth-2);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int result=getNum(num);
        System.out.println(result);
    }

}
