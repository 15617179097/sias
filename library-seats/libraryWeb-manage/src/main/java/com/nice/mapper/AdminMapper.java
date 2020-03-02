package com.nice.mapper;

import com.nice.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-13 12:30
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface AdminMapper {

    //登陆 或者 查询带密码
    public Admin findAdminAndLogin(Admin admin);

    //查询用户
    public List<Admin> findAdmin(Admin admin);

    //添加用户
    public int insertAdmin(Admin admin);

    //修改用户信息
    public int updataAdmin(Admin admin);

    //修改用户状态
    public int updataAdminStatus(Admin admin);

    //删除用户
    public int daleteAdmin(Integer id);

}
