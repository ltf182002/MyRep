package com.turing.sb002.controller;

import com.turing.sb002.dao.DeptRepository;
import com.turing.sb002.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Author 长沙图灵科技学院
 * @Company www.tulingedu.com
 */
@RestController
@RequestMapping("/dept")
public class DeptController {

    //依赖Dao层
    @Autowired
    private DeptRepository repository;

    //查询所有
    @RequestMapping("/")
    public List<Dept> findAll(){
        return repository.findAll();
    }


    @RequestMapping("/order/{id}")
    public List<Dept> findOrder(@PathVariable("id")int id){
        return repository.findByDeptnoGreaterThanOrderByDeptnoDesc(id);
    }

    @RequestMapping("/like/{name}/{loc}")
    public List<Dept> findLike(@PathVariable("name")String name,@PathVariable("loc")String loc){
        return repository.findByDnameLikeAndLocLike("%"+name+"%", "%"+loc+"%");
    }

    //根据id查询
    @RequestMapping("/{id}")
    public Dept findById(@PathVariable("id") int id){
        Optional<Dept> op = repository.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

    //添加
    @RequestMapping("/save")
    public Dept add(){
        Dept dept = new Dept();
        dept.setDname("TEST");
        dept.setLoc("CHANGSHA");
        repository.save(dept);
        return dept;
    }

    //修改
    @RequestMapping("/update/{id}")
    public Dept update(@PathVariable("id") int id){
        Dept dept = repository.findById(id).get();
        dept.setDname("TEST22");
        dept.setLoc("长沙");
        return repository.save(dept);
    }

    //删除
    @RequestMapping("/delete/{id}")
    public Dept delete(@PathVariable("id")int id){
        Dept dept = repository.findById(id).get();
        repository.delete(dept);
        return dept;
    }
}
