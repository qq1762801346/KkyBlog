package per.kky.modules.system.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import per.kky.common.base.BaseEntity;

@Data
@Accessors(chain = true)
public class Menu extends BaseEntity {

    private Long parentId;
    private String menuName;
    private String menuRouter;
    private String menuType;
    private String menuIcon;
    private Integer menuSort;

}
