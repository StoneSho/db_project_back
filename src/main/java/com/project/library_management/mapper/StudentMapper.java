package com.project.library_management.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.library_management.entity.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student>{
    @Select("SELECT s.* FROM student s " +
            "JOIN grade g ON s.studentId = g.student_id " +
            "WHERE g.course_id = #{courseId}")
    List<Student> selectStudentsByCourseId(int courseId);
}
