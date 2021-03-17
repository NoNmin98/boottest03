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

import java.awt.print.Book;
import java.util.List;
import java.util.Map;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-17:39
 */
@Controller
@RestController
public class indexController {

    @Autowired
    PersonServer personServer;
    Integer updateid;

    @GetMapping(value = {"/index", "/index.html", "/"})
    //通过form表单传递前端数据，还有注解@RequestParam
    public String showAll(Integer searchText, Model model) {
        if (searchText == null) {
            model.addAttribute("allper", personServer.getAllPerson());
            //不能写成 "/index"  要写成 "index"
            return "index";
        } else {
            model.addAttribute("getaPersonById", personServer.getPersonById((Integer) searchText));
            return "index";
        }
    }

    //跳转到addPerson页面
    @GetMapping(value = {"/addPerson", "/addPerson.html"})
    public String addperson() {
        return "addPerson";
    }

    @GetMapping(value = {"/addPersonCon", "/addPersonCon.html"})
    //多个参数需要通过注解来让系统识别出来，如果只有一个参数则可以不用加参数
    public String addpersonCon(Person person) {
        //System.out.println(person.getStuName()+person.getStuGender());
        personServer.addAPerson(person);
        return "redirect:/index";
    }

    //通过地址获取到前端数据
    @GetMapping("/deletePerson/{id}")
    public String delete(@PathVariable("id") Integer id) {
        personServer.deleteAPersonById(id);
        return "redirect:/index";
    }

    //跳转到update页面去
    @GetMapping("/updatePerson/{id}")
    public String updatePerson(@PathVariable("id") Integer id) {
        updateid = id;
        return "updatePerson";
    }

    //实现修改
    @GetMapping("/updatePersonCon")
    public String updatePersonCon(Person person) {
        personServer.updateAPersonById(updateid, person.getStuName(), person.getStuGender());
        return "redirect:/index";
    }

    //----------------------------------------------测试前后端分离-----------------------------------------------------------
    //获取所有数据,注意这里返回json数据我们需要返回RestController
    //和非前后端分离的项目不同的是，这个返回的是一个json数据，前端通过axios火毒到数据2
    @GetMapping(value = {"/findAll", "/findAll.html"})
    public List<Person> findAll() {
        return personServer.getAllPerson();
    }

    //前端传递过来的json格式数据，需要使用功能@RequestBody才能转换成为Person对象
    @PostMapping(value = {"/save", "/save.html"})
    public void save(@RequestBody Person person) {
        personServer.addAPerson(person);
    }

    //通过路径传递数据都需要添加@PathVariable注解
    @GetMapping("/findById/{id}")
    public Person findById(@PathVariable("id") Integer id) {
        return personServer.getPersonById(id);
    }

    //修改一个数据,前端传递过来的json格式数据，需要使用功能@RequestBody才能转换成为Person对象
    @PutMapping("/update")
    public void updateById(@RequestBody Person person) {
        personServer.updateAPersonById(person.getId(), person.getStuName(), person.getStuGender());
    }

    //删除一个数据
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        personServer.deleteAPersonById(id);
    }
}
