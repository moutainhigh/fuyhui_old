package com.fujfu.common.util;

public class TestDemo1 {
     public static int a = 0;

     static {
         a = 10;
         System.out.println("父类的静态代码块在执行a=" + a);
     }

     {
         a = 8;
         System.out.println("父类的非静态代码块在执行a=" + a);
     }

     public TestDemo1() {
         this("a在父类带参构造方法中的值：" + TestDemo1.a); // 调用另外一个构造方法
         System.out.println(a);
         System.out.println("父类无参构造方法在执行a=" + a);
     }

     public TestDemo1(String n) {
         System.out.println(n);
         System.out.println(a);

     }

     public static void main(String[] args) {
         TestDemo1 tsc = null;
         System.out.println("!!!!!!!!!!!!!!!!!!!!!");
         tsc = new TestDemo1();
     }
 }

