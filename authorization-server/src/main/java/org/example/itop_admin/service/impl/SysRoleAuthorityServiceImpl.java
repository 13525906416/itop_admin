package org.example.itop_admin.service.impl;

import org.example.itop_admin.entity.SysRoleAuthority;
import org.example.itop_admin.mapper.SysRoleAuthorityMapper;
import org.example.itop_admin.service.ISysRoleAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色菜单多对多关联表 服务实现类
 * </p>
 *
 * @author zhaoyb
 * @since 2024-06-06
 */
@Service
public class SysRoleAuthorityServiceImpl extends ServiceImpl<SysRoleAuthorityMapper, SysRoleAuthority> implements ISysRoleAuthorityService {

}
