package com.nice.web.mapper;


import com.nice.web.pojo.SignIn;
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
public interface SignInMapper {
    //进行签到或者违约
    int insertSignIn(SignIn signIn);

    //查询未签到记录
    List<Integer> findSignInReports(@Param("month") String month);
}
