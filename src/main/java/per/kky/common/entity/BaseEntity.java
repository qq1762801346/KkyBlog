package per.kky.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class BaseEntity {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

}
