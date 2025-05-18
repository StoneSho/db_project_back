package com.project.library_management.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.project.library_management.entity.Student;
import com.project.library_management.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  //使得该类中所有方法允许跨域
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    //查询全部学生信息
    @GetMapping("/student/selectAllstudent")
    public List<Student> query(){
        List<Student> list = studentMapper.selectList(null);  //条件查询为空，即查询所有
        return list;
    }

    //根据studentId查找
    @GetMapping("/student/selectByid/{id}")
    public List selectByid(@PathVariable int id){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("studentId",id);
        return studentMapper.selectList(queryWrapper);
    }

    //根据姓名查找
    @GetMapping("/student/selectByname/{name}")
    public List selectByname(@PathVariable String name){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("name",name);
        System.out.println(name);
        return studentMapper.selectList(queryWrapper);
    }

    //根据学号查找
    @GetMapping("/student/selectBynumber/{studentNumber}")
    public List selectBynumber(@PathVariable String studentNumber){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<Student>();
        queryWrapper.eq("studentNumber",studentNumber);
        System.out.println(studentNumber);
        return studentMapper.selectList(queryWrapper);
    }

    @PostMapping("/student/addstudent")
    public String addStudent(@RequestBody Student student){  //想使用json传输数据必须加RequestBody注释才能将对象转换为json数据
        int list = studentMapper.insert(student);
        System.out.println(student);
        return "添加学生: "+student.toString();
    }

    // 删除学生（按ID）
    @DeleteMapping("/student/deleteById/{id}")
    public String deleteById(@PathVariable int id) {
        int result = studentMapper.deleteById(id);
        if(result > 0)
            return "删除成功，删除学生ID为：" + id;
        else
            return "删除失败，未找到该ID";
    }

    // 删除学生（按学号）
    @DeleteMapping("/student/deleteByNumber/{studentNumber}")
    public String deleteByNumber(@PathVariable String studentNumber) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("studentNumber", studentNumber);
        int result = studentMapper.delete(queryWrapper);
        if(result > 0)
            return "删除成功，学号为：" + studentNumber;
        else
            return "删除失败，未找到该学号";
    }

    // 修改学生（按学号）
    @PutMapping("/student/updateBynumber")
    public String updateBynumber(@RequestBody Student student){
        UpdateWrapper<Student> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("studentNumber",student.getStudentNumber());
        Student newstudent = new Student();
        newstudent.setName(student.getName());
        newstudent.setGender(student.getGender());
        newstudent.setAge(student.getAge());
        newstudent.setMajor(student.getMajor());
        newstudent.setClassName(student.getClassName());
        newstudent.setPhone(student.getPhone());
        newstudent.setEmail(student.getEmail());
        int result = studentMapper.update(newstudent,updateWrapper);
        if(result > 0)
            return "修改成功，修改后的学生数据为：" + student;
        else
            return "修改失败";
    }

}

