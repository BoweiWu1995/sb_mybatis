package com.mydemo.controller;

import com.mydemo.mapper.StudentMapper;
import com.mydemo.model.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author wuwei
 * @create 2019/9/30 9:24
 * @desc
 **/
@Api(tags = "用户管理")
@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @ApiOperation(value = "获取用户列表")
    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentMapper.getAll();
    }

    @ApiOperation(value = "根据id获取用户")
    @GetMapping("/getStudent/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studentMapper.getStudent(id);
    }

    @ApiOperation(value = "创建用户", notes = "根据stu对象创建用户")
    @PostMapping("/add")
    public Long save(@RequestBody Student student) {
        student.setCreateDate(new Date());
        log.info("插入学生");
        return studentMapper.insertStudent(student);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用户详细信息", notes = "根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParam(paramType = "path", dataType = "String", name = "id", value = "用户编号", required = true, example = "1")
    public Long update(@RequestBody Student student) {
        return studentMapper.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    public Long delete(@PathVariable("id") String id) {
        return studentMapper.deleteStudent(id);
    }
}
