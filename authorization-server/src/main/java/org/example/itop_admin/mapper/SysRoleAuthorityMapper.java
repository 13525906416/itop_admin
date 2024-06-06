package org.example.itop_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.itop_admin.entity.SysRoleAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色菜单多对多关联表 Mapper 接口
 * </p>
 *
 * @author zhaoyb
 * @since 2024-06-06
 */
@Mapper
@Repository
public interface SysRoleAuthorityMapper extends BaseMapper<SysRoleAuthority> {

}
