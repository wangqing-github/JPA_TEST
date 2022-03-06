package com.jpa.example.controller;

import com.jpa.example.service.JpaTestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/jpa/test")
public class JpaTestController {
    @Resource
    JpaTestService jpaTestService;

    @RequestMapping("/findById")
    public Object testFindById() {
        return jpaTestService.findById();
    }

    @RequestMapping("/save")
    public Object save(){
        return jpaTestService.save();
    }

    @RequestMapping("/update")
    public Object update(){
        return jpaTestService.update();
    }

    @RequestMapping("/delete")
    public Object delete(){
        return jpaTestService.delete();
    }

    @RequestMapping("/find/special")
    public Object findSpecial(){
        return jpaTestService.special();
    }

    @RequestMapping("/delete/special")
    public Object deleteSpecial(){
        return jpaTestService.deleteSpecial();
    }
}
