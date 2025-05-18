package com.project.library_management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.project.library_management.entity.Course;
import com.project.library_management.entity.Student;
import com.project.library_management.mapper.CourseMapper;
import com.project.library_management.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin  // 允许跨域
public class CourseController {
    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private StudentMapper studentMapper;

    // 查询全部课程
    @GetMapping("/course/selectAll")
    public List<Course> selectAll() {
        return courseMapper.selectList(null);
    }

    // 按课程ID查询
    @GetMapping("/course/selectById/{course_id}")
    public List<Course> selectById(@PathVariable int course_id) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        queryWrapper.eq("course_id", course_id);
        return courseMapper.selectList(queryWrapper);
    }

    // 按课程代码查询
    @GetMapping("/course/selectByCode/{course_code}")
    public List<Course> selectByCode(@PathVariable String course_code) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        queryWrapper.eq("course_code", course_code);
        System.out.println(course_code);
        return courseMapper.selectList(queryWrapper);
    }

    // 按课程名称查询
    @GetMapping("/course/selectByName/{course_name}")
    public List<Course> selectByName(@PathVariable String course_name) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<Course>();
        queryWrapper.eq("course_name", course_name);
        System.out.println(course_name);
        return courseMapper.selectList(queryWrapper);
    }

    // 添加课程
    @PostMapping("/course/addcourse")
    public String addCourse(@RequestBody Course course) {
        int result = courseMapper.insert(course);
        System.out.println(course);
        return "添加课程: " + course.toString();
    }

    // 删除课程（按ID）
    @DeleteMapping("/course/deleteById/{course_id}")
    public String deleteById(@PathVariable int course_id) {
        int result = courseMapper.deleteById(course_id);
        if (result > 0)
            return "删除成功，课程ID为：" + course_id;
        else
            return "删除失败，未找到该ID";
    }

    // 删除课程（按课程代码）
    @DeleteMapping("/course/deleteByCode/{course_code}")
    public String deleteByCode(@PathVariable String course_code) {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("course_code", course_code);
        int result = courseMapper.delete(queryWrapper);
        if (result > 0)
            return "删除成功，课程代码为：" + course_code;
        else
            return "删除失败，未找到该课程代码";
    }

    // 修改课程（按课程代码）
    @PutMapping("/course/updateByCode")
    public String updateByCode(@RequestBody Course course) {
        UpdateWrapper<Course> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("course_code", course.getCourse_code());
        Course newCourse = new Course();
        newCourse.setCourse_name(course.getCourse_name());
        // 这里只能更新你允许前端传递的字段
        int result = courseMapper.update(newCourse, updateWrapper);
        if (result > 0)
            return "修改成功，修改后的课程数据为：" + course;
        else
            return "修改失败";
    }

    // 查询选修某课程的所有学生
    @GetMapping("/course/students/{course_id}")
    public List<Student> getStudentsByCourseId(@PathVariable int course_id) {
        return studentMapper.selectStudentsByCourseId(course_id);
    }
}