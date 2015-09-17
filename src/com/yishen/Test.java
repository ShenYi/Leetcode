package com.yishen;

/**
 * Created by yishen on 15/6/27.
 */
public class Test {
    public static void main(String[] args) {
            new Test().test1();

    }

    public void test1() throws RuntimeException{
        int a=  1;
        if (a!=1) {
            throw new RuntimeException();
        }

    }
}
