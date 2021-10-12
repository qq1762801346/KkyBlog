package per.kky.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import per.kky.modules.system.entity.Menu;
import per.kky.modules.system.vo.MenuVO;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    List<MenuVO> listAllMenu();

}
