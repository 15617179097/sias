package com.nice.web.mapper;


import com.nice.web.pojo.SignIn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

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

    int insertSignIn(SignIn signIn);
}
