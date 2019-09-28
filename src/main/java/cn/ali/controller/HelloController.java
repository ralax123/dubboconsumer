package cn.ali.controller;

import cn.ali.dubo.service.HelloService;
import cn.ali.dubo.service.LogService;
import cn.ali.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    /**
     * 使用随机默认负载均衡
     * 等同于xml文件中:<dubbo:consumer check="false"  loadbalance="roundrobin"  timeout="1000"  retries="1"></dubbo:consumer>-->
     */
//    @Reference(check = false, loadbalance = "roundrobin", timeout = 1000,retries = 3)
    @Autowired
    private HelloService2 helloService;

    @Autowired
    private LogService logService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helli(String name) {
        String s = helloService.sayHello(name);
        return s;
    }

    @RequestMapping("/log")
    @ResponseBody
    public String log(String name) {
        String log = logService.log(name);
        return log;
    }


}
