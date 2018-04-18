package com.zcy.ssm;


public class test {
    public  void localvarGc4(){
        {
            byte[] a=new byte[6*1024*1024];
        }
        System.gc();

    }
    public static void main(String[] args) {
        test t=new test();
        System.out.println("test");
        t.localvarGc4();
    }
}
