package com.project.library_management.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.library_management.entity.Grade;
import com.project.library_management.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin // 允许跨域请求
public class GradeController {
    @Autowired
    private GradeMapper gradeMapper;

    // 查询全部成绩
    @GetMapping("/grade/selectAll")
    public List<Grade> selectAll() {
        return gradeMapper.selectList(null);
    }

    // 按成绩ID查询
    @GetMapping("/grade/selectById/{grade_id}")
    public List<Grade> selectById(@PathVariable int grade_id) {
        QueryWrapper<Grade> wrapper = new QueryWrapper<>();
        wrapper.eq("grade_id", grade_id);
        return gradeMapper.selectList(wrapper);
    }

    // 按学生ID查询
    @GetMapping("/grade/selectByStudentId/{student_id}")
    public List<Grade> selectByStudentId(@PathVariable int student_id) {
        QueryWrapper<Grade> wrapper = new QueryWrapper<>();
        wrapper.eq("student_id", student_id);
        return gradeMapper.selectList(wrapper);
    }

    // 按课程ID查询
    @GetMapping("/grade/selectByCourseId/{course_id}")
    public List<Grade> selectByCourseId(@PathVariable int course_id) {
        QueryWrapper<Grade> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", course_id);
        return gradeMapper.selectList(wrapper);
    }


}