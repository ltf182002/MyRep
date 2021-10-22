package com.turing.sb002.dao;

import com.turing.sb002.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Author 长沙图灵科技学院
 * @Company www.tulingedu.com
 */
public interface DeptRepository extends JpaRepository<Dept,Integer> {

    //复杂查询：查询部门编号>10，按降序排列
    public List<Dept> findByDeptnoGreaterThanOrderByDeptnoDesc(int id);

//    //使用JPQL
//    @Query("select d from Dept d where d.deptno>10 order by d.deptno desc")
//    public List<Dept> find01(Integer DEPTNO);

    //模糊查询：查询部门名称中包含S的，并且地址中包含S的。
    public List<Dept> findByDnameLikeAndLocLike(String name,String loc);
}
