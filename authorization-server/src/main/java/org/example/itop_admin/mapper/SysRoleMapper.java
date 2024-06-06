package org.example.itop_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.itop_admin.entity.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统角色表 Mapper 接口
 * </p>
 *
 * @author zhaoyb
 * @since 2024-06-06
 */
@Mapper
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
