package per.kky.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import per.kky.modules.system.entity.Menu;
import per.kky.modules.system.mapper.MenuMapper;
import per.kky.modules.system.service.IMenuService;
import per.kky.modules.system.vo.MenuVO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private final MenuMapper menuMapper;

    @Override
    public List<MenuVO> initRouters() {
        List<MenuVO> menuList = menuMapper.listAllMenu();
        List<MenuVO> routes = new LinkedList<>();
        for(MenuVO menuVO : menuList) {
            if(menuVO.getParentId() == null) {
                routes.add(menuVO);
                recursion(menuVO, menuVO.getId(), menuList);
            }
        }
        return routes;
    }

    /**
     * 递归生成树形菜单数据结构
     * @param node
     * @param parentId
     * @param list
     */
    private void recursion(MenuVO node, Long parentId, List<MenuVO> list) {
        List<MenuVO> menuList = list.stream().filter(
                menuVO -> menuVO.getParentId() == parentId
        ).collect(Collectors.toList());
        node.setChildren(menuList);
        for(MenuVO menuVO : menuList) {
            if(menuVO.getHasChildren() > 0) {
                recursion(menuVO, menuVO.getId(), list);
            }
        }
    }

}
