package per.kky.modules.system.vo;

import lombok.Data;
import per.kky.modules.system.entity.Menu;

import java.util.List;

@Data
public class MenuVO extends Menu {

    private Integer hasChildren;

    private List<MenuVO> children;

}
