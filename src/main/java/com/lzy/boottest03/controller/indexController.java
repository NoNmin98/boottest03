package com.lzy.boottest03.controller;

import com.lzy.boottest03.bean.Person;
import com.lzy.boottest03.service.PersonServer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-17:39
 */
@Controller
public class indexController {

    @Autowired
    PersonServer personServer;
    Integer updateid;

    @GetMapping(value = {"/index","/index.html"})
    //通过form表单传递前端数据，还有注解@RequestParam
    public String showAll(Integer searchText,Model model){
        if (searchText== null){
            model.addAttribute("allper",personServer.getAllPerson());
            //不能写成 "/index"  要写成 "index"
            return "index";
        }
        else{
            model.addAttribute("getaPersonById",personServer.getPersonById((Integer) searchText));
            return "index";
        }
    }

    //跳转到addPerson页面
    @GetMapping( value = {"/addPerson","/addPerson.html"})
    public String addperson(){
            return "addPerson";
    }

    @GetMapping(value = {"/addPersonCon","/addPersonCon.html"})
    //多个参数需要通过注解来让系统识别出来，如果只有一个参数则可以不用加参数
    public String addpersonCon(Person person){
        //System.out.println(person.getStuName()+person.getStuGender());
        personServer.addAPerson(person);
        return "redirect:/index";
    }

    //通过地址获取到前端数据
    @GetMapping("/deletePerson/{id}")
    public String delete(@PathVariable("id")Integer id){
        personServer.deleteAPersonById(id);
        return "redirect:/index";
    }

    //跳转到update页面去
    @GetMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable("id")Integer id){
        updateid=id;
        return "updatePerson";
    }
    //实现修改
    @GetMapping("/updatePersonCon")
    public String updatePersonCon(Person person){
        personServer.updateAPersonById(updateid,person.getStuName(),person.getStuGender());
        return "redirect:/index";
    }
}
