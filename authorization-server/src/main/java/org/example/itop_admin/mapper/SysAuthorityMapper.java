package org.example.itop_admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.itop_admin.entity.SysAuthority;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 系统菜单表 Mapper 接口
 * </p>
 *
 * @author zhaoyb
 * @since 2024-06-06
 */
@Mapper
@Repository
public interface SysAuthorityMapper extends BaseMapper<SysAuthority> {

}
