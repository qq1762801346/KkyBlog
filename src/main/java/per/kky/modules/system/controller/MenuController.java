package per.kky.modules.system.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.kky.modules.system.service.IMenuService;
import per.kky.modules.system.vo.MenuVO;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/kky-system/menu")
public class MenuController {

    private final IMenuService menuService;

    @PostMapping("/initRouters")
    public List<MenuVO> initRouters() {
        return menuService.initRouters();
    }

}
