package per.kky.modules.system.entity;

import lombok.Data;
import per.kky.common.entity.BaseEntity;

@Data
public class User extends BaseEntity {

    private String name;
    private Integer age;
    private String account;
    private String password;

}
