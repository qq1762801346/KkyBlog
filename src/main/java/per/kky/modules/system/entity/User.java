package per.kky.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import per.kky.common.entity.BaseEntity;

@Data
@Accessors(chain = true)
@TableName("blog_user")
public class User extends BaseEntity {

    private String userAcc;
    private String userPwd;
    private String userNick;
    private String headIcon;
    private Long roleId;

}
