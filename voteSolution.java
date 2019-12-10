import java.util.Scanner;

public class voteSolution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();//候选人数
            String s2=sc.nextLine();//候选人
            String s3=sc.nextLine();//投票人数
            String s4=sc.nextLine();//投票情况
            String[] str1=s2.split( " ");
            String[] str2=s4.split(" ");
            getTicket(s1,str1,s2,str2);
        }
    }
    public static void getTicket(String s1,String []p,String s2,String[]q){
        //p候选人
        //q投票
        int n=p.length;
        int m=q.length;
        int sum=0;
        for(int i=0;i<n;i++){
            int num=0;
            for(int j=0;j<m;j++){
                if(p[i].equals(q[j])){
                    num++;
                }
            }
            sum+=num;
            System.out.println(p[i]+" "+":"+num);
        }
        int invalid=0;
        if(sum<m){
            invalid=m-sum;
            System.out.println("invalid :"+invalid);
        }else{
            System.out.println("invalid :"+invalid);
        }
    }
}
