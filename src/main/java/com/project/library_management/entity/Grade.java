package com.project.library_management.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("grade")
public class Grade {
    @TableId(type=IdType.AUTO)//id为主键且为自增，并且插入时会自动读取数据库中自增的id，并赋值给该User对象的id，使操作者可以在控制台读取到此次操作的id，无需到数据库查看
    private int grade_id;
    private int student_id;
    private int course_id;
    private Double score;

    public int getGrade_id() {
        return grade_id;
    }

    public void setGrade_id(int grade_id) {
        this.grade_id = grade_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "grade_id=" + grade_id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", score=" + score +
                '}';
    }
}
