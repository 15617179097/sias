package com.nice.mapper;


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
public interface WxUserMapper {

    //查询微信用户列表
    public List< Map<String, Object>> findWxUser(@Param("studentId") Integer studentId);
}
