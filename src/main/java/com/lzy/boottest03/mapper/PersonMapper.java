package com.lzy.boottest03.mapper;

import com.lzy.boottest03.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: lzy
 * @description:
 * @date: 2021-03-03-17:31
 */
@Mapper
public interface PersonMapper {
    List<Person> getAllPerson();

    //    根据id查找
    Person getPersonById(Integer id);

    //    添加成员
    //Person addAPerson(@Param("stuName") String stuName,@Param("stuGender") String stuGender);
    void addAPerson(Person person);

    void deleteAPersonById(Integer id);

    void updateAPersonById(@Param("id") Integer id, @Param("stuName") String stuName, @Param("stuGender") String stuGender);

    //void updateAPersonById(Integer id,String stuName,String stuGender);
}
