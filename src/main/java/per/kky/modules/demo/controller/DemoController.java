package per.kky.modules.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.kky.modules.demo.entity.Student;
import per.kky.modules.demo.service.IStudentService;
import per.kky.modules.demo.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IStudentService service;

    @RequestMapping("/test")
    public String test() {
        Student student = new Student();
        student.setName("张三");
        service.save(student);
        return service.getById(student.getId()).toString();
    }

}
