package com.imooc;

public class Singleton implements behave {
    private static Singleton instance = null;

    private Singleton() {
    }
    public static Singleton getInstance(){
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    @Override
    public void go() {

    }

    public static void main(String[] args){

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        if (s1 == s2)
            System.out.println("是同一对象");
    }

}
