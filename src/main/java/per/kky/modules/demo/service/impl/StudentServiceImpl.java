package per.kky.modules.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import per.kky.modules.demo.entity.Student;
import per.kky.modules.demo.mapper.StudentMapper;
import per.kky.modules.demo.service.IStudentService;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
