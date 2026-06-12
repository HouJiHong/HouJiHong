package fuxi;

import java.util.Scanner;

public class ZhiShu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int flag=0;
        for(int i=2;i<n;i++){
            if(n%i==0){
                flag=1;
                System.out.println(n+"不是质数。");
                break;
            }



        }

        if (flag==0) {
            System.out.println(n+"是质数。");
        }
    }
}
