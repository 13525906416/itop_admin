package org.example.itop_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.itop_admin.entity.Oauth2ThirdAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 三方登录账户信息表 Mapper 接口
 * </p>
 *
 * @author zhaoyb
 * @since 2024-06-06
 */
@Mapper
@Repository
public interface Oauth2ThirdAccountMapper extends BaseMapper<Oauth2ThirdAccount> {

}
