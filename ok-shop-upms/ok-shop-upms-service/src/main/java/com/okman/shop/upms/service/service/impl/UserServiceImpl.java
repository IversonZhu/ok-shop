package com.okman.shop.upms.service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.okman.shop.upms.service.entity.SysUser;
import com.okman.shop.upms.service.mapper.SysUserMapper;
import com.okman.shop.upms.service.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户服务实现类
 * </p>
 *
 * @Author Iverson.Z
 * @Description 功能说明：
 * @Date 2021/1/8 16:44
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {}
