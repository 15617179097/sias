package com.nice.mapper;

import com.nice.pojo.SignIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface SignInMapper {
    //查询今天所有的未签到
    List<SignIn> findSignIn(@Param("tomorrowCreateTime") String tomorrowCreateTime, @Param("tomorrowEndTime") String tomorrowEndTime);
    //添加签到时间
    int insertSignIn(SignIn signIn);
    //根据预约修改
    int updateSignIn(@Param("state") Integer state, @Param("subscribeId") Integer subscribeId);

}
