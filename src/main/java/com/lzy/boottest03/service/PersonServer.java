package com.lzy.boottest03.service;

import com.lzy.boottest03.bean.Person;
import com.lzy.boottest03.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-18:43
 */
@Service
public class PersonServer {

    @Autowired
    PersonMapper personMapper;

    public List<Person> getAllPerson(){
        return personMapper.getAllPerson();
    }

    public Person getPersonById(Integer id){return personMapper.getPersonById(id);}

   // public Person addAPerson( String stuName, String stuGender){return personMapper.addAPerson(stuName,stuGender);}
    public void addAPerson(Person person){ personMapper.addAPerson(person);}

    public void deleteAPersonById(Integer id){personMapper.deleteAPersonById(id);}

    public void updateAPersonById(Integer id,String stuName,String stuGender){personMapper.updateAPersonById(id,stuName,stuGender);}
}
