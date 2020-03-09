package com.nice.web.mapper;

import com.nice.web.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
@Mapper
public interface UserInfoMapper {
    List<Map<String,Object>> findUserInfo();

    //根据userId修改学号以及状态
    public int updateUserInfoState(UserInfo userInfo);

    //删除学号信息
    public int deleteUserInfo(@Param("userId")Integer userId);
}


