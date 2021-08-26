package com.demo.proxy;

interface Interface{
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements Interface{

    @Override
    public void doSomething() {
        System.out.println("do some thing");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class SimpleProxy implements Interface{
    private Interface proxied;
    public SimpleProxy(Interface proxied){
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse" + arg);
        proxied.somethingElse(arg);
    }
}


public class SimpleProxyDemo {
    public static void customer(Interface inface){
        inface.doSomething();
        inface.somethingElse("banana");
    }

    public static void main(String[] args) {
        customer(new RealObject());
        customer(new SimpleProxy(new RealObject()));
    }
}
