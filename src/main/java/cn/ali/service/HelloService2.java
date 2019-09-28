package cn.ali.service;

import cn.ali.dubo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService2 {
    @Autowired
    private HelloService helloService;

    public String sayHello(String name) {
        String hello = helloService.sayHello(name);
        String HELLO = hello.toUpperCase();
        return HELLO;
    }
}
