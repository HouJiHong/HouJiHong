package game.ui;

import game.domain.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    ArrayList<User> list = new ArrayList<>();
    //这个方法表示的就是登录注册的主页面（是以控制台的形式进行展示的）
    public void start(){
        while (true) {
            System.out.println("欢迎来到登录界面");
            System.out.println("|================================|");
            System.out.println("|             文字游戏            |");
            System.out.println("|================================|");
            System.out.println("请选择：1登录 2注册 3退出");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch(choose){
                case "1"->login(list);
                case "2"->register(list);
                case "3"->System.exit(0);
                default->System.out.println("输入错误！");
            }
        }
    }
    public void login(ArrayList<User> list){
        System.out.println("用户选择登录");
    }
    public void register(ArrayList<User> list){
        System.out.println("用户选择注册");
        //什么叫做注册？
        //键盘录入用户名 密码,---User对象--->集合
        //1.创建User对象（空参）
        User u = new User();
        //2．键盘录入用户名
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名：");
            String useName = sc.next();
            //  校验用户名是否符合要求
            //  u.setUsername();
            //1.用户名唯一
            //2.长度必须在3～16位
            //3.只能由字母、数字组成，不能是纯数字
            if (!checkLens(3, 16, useName)) {
                System.out.println("用户名长度不符合要求！");
                continue;
            }
            if(!checkName(useName)){
                System.out.println("用户名格式错误！");
                continue;
            }
            if (contains(list, useName)) {
                System.out.println("用户名已存在！");
                continue;
            }
            u.setName(useName);
            break;
        }


        //3．键盘录入密码
        //  校验密码是否符合要求
        //  u.setPassword();

        while (true) {
            System.out.println("请输入第一次密码：");
            String pwd1 = sc.next();
            System.out.println("请输入第二次密码：");
            String pwd2 = sc.next();
            if(!checkLens(3,8,pwd1)){
                System.out.println("密码长度不符合要求！");
                continue;
            }
            if(!checkPassword(pwd1)){
                System.out.println("密码格式错误！");
                continue;
            }
            if(!pwd1.equals(pwd2)){
                System.out.println("两次密码不一致！");
                continue;
            }
            u.setPassword(pwd1);
            break;
        }


        //4．把User对象添加到集合当中
        //5.提示成功
    }

    public boolean checkPassword(String password){
        int[] counts = counts(password);
        return counts[0] > 0 && counts[1] > 0 && counts[2] == 0;
    }

    public  boolean contains(ArrayList<User> list,String name){
        for (int i = 0; i < list.size(); i++) {
            User userName = list.get(i);
            if (userName.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkName(String name){
        int[] counts = counts(name);
        return counts[0] > 0 && counts[1] >= 0 && counts[2] == 0;
    }

    public int[] counts(String name){
        int charCount = 0;
        int numCount = 0;
        int otherCount = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
                charCount++;
            } else if (c>='0' && c<='9'){
                numCount++;
            }else{
                otherCount++;
            }
        }
        return new int[]{charCount,numCount,otherCount};

    }

    public boolean checkLens(int minLen, int maxLen,String str){
        return str.length() >= minLen && str.length() <= maxLen;
    }
}
