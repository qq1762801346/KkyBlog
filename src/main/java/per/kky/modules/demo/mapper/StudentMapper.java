package per.kky.modules.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.kky.modules.demo.entity.Student;

public interface StudentMapper extends BaseMapper<Student> {

    Student selectById(Long id);

}
