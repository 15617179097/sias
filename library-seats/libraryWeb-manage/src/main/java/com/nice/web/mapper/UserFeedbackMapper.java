package com.nice.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:41
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface UserFeedbackMapper {

    //获取用户反馈列表
    List<Map<String,Object>> findUserFeedback(@Param("studentId")String studentId);

    //完成用户反馈
    int updateUserFeedback(@Param("id")int id);
}
