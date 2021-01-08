package com.hzero.order.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProviderController {
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            System.out.println(s);
        }
        return "hello spring cloud!";
    }

    @RequestMapping(value = "/nice",method = RequestMethod.GET)
    public String nice(){
        List<String> services = discoveryClient.getServices();
        for(String s : services){
            System.out.println(s);
        }
        return "nice to meet you!";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        List<ServiceInstance> instances = discoveryClient.getInstances("HZERO-ORDER-29706");
        for (ServiceInstance instance:instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return "this is a instance";
    }
}
