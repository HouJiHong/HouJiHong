package com.HJh.test.oop.duoxiancheng.lianxi;

class SimBank
{
  private static int Sum=100;
  public synchronized static void deposits(int saveSum)  
  {
	  int temp=Sum;
	  temp=temp+ saveSum;
	  //人为制造线程休眠, 时间在1000毫秒内随机产生
	  try{
          Thread.sleep((int)(1000*Math.random()));
         }catch(InterruptedException e){
		  e.printStackTrace();
       }
	  Sum=temp;
	  System.out.println("存入金额："+saveSum);
	  System.out.println("当前账户余额："+Sum);	
  }


  public synchronized static void withdrawals(int getSum)  
  {
	  if(Sum<getSum)
	  {
		  System.out.println("取钱失败，余额不足！");
		  return;
	  }
	  Sum=Sum-getSum;
//	  int temp=Sum;
//	  temp=temp-getSum;
	  //人为制造线程休眠, 时间在1000毫秒内随机产生
	  try{
        Thread.sleep((int)(1000*Math.random()));
        }catch(InterruptedException e){
		  e.printStackTrace();
       }
//	  Sum=temp;
	  System.out.println("取出金额："+getSum);
	  System.out.println("当前账户余额："+Sum);	
   }
}

//模拟用户线程。为了直观，只定义了取钱操作
class Customer extends Thread
{
	public void run()
	{
		//循环10次，每次随机取出50以内的金额
		for (int i=1;i<=10 ;i++ )
		{
			SimBank.withdrawals ((int)(50*Math.random()));
			//SimBank. deposits ((int)(1000*Math.random()));

		} 
	}
}

//测试类，模拟四个取款机同时对该账户操作 
public class Test
{
  public static void main(String[] args) 
	{
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		Customer c4 = new Customer();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}