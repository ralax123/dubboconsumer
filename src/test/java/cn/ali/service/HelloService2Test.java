package cn.ali.service;

import cn.ali.dubo.service.HelloService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;


public class HelloService2Test extends BaseTest {

    @Autowired
    private HelloService2 helloService2;

    @Test
    public void sayHello() {
        HelloService helloService = Mockito.mock(HelloService.class);
        ReflectionTestUtils.setField(helloService2, "helloService", helloService);
        Mockito.when(helloService.sayHello("aa")).thenReturn("aaaaaa");
        Mockito.when(helloService.sayHello("bb")).thenReturn("bbbbbb");
        Mockito.when(helloService.sayHello("cc")).thenReturn("cccccc");
//        Mockito.when(helloService.sayHello(Mockito.any(String.class))).thenReturn("qqqqqqq");

        String result = helloService2.sayHello("aa");
        Assert.assertEquals("AAAAAA", result);

    }

}