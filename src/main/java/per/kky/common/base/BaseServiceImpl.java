package per.kky.common.base;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import per.kky.modules.system.entity.User;
import per.kky.modules.system.util.UserUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {

    private T temp;
    private M baseMapper;

    @Override
    public boolean deleteLogic(String ids) {
        List<Long> idList = Convert.toList(Long.class, ids);
        List<T> list = new ArrayList<>();
        idList.forEach(id -> {
            T entity = ObjectUtil.clone(temp);
            entity.setId(id).setIsDeleted(1).setUpdateUser(UserUtil.getUser().getId()).setUpdateTime(DateUtil.date());
            list.add(entity);
        });
        return updateBatchById(list);
    }

}
