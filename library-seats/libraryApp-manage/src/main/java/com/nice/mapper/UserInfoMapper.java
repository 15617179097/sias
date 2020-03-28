package com.nice.mapper;

import com.nice.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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
public interface UserInfoMapper {
    Map<String,Object> login(UserInfo userInfo);

    //查询用户信息
    Map<String,Object> findUserInfo(UserInfo user);

    //添加用户信息
    int insertUserInfo(UserInfo userInfo);

    //每月的最后一天的22.50执行
    int updateAllUserInfo(@Param("creditScore") Integer creditScore);

    //违规信誉减一
    int updateUserInfoCreditScore();

    //用户列表
    List<Map<String,Object>> findAllUsers();

    //删除用户信息
    int updateUserInfo(@Param("userId")Integer userId,@Param("studentId")String studentId);
}
