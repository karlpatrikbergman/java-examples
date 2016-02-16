package se.patrikbergman.java.basictest;

class App {


    App() {
        //Child c = new Parent();//Incompatible type
        Parent p = new Child();
    }

    class Parent {

    }

    class Child extends Parent {

    }



}
