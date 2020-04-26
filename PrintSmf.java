package ru.gb.java_3.hw_7;

public class PrintSmf {
    @Test(priority = 0)
    public void print(){
        System.out.println("Hello!");
    }
    @Test(priority = 1)
    public void printName(){
        System.out.println("My name is Artem.");
    }
    @BeforeSuite
    public void start(){
        System.out.println("App is run!");
    }
//    @BeforeSuite
//    public void startEx(){
//        System.out.println("Ex");
//    }
    @AfterSuite
    public void finish(){
        System.out.println("App is complete");
    }
}
