package com.nice.mapper;

import com.nice.pojo.WxUserInfo;
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
public interface WxUserInfoMapper {
 //校验用户是否存在
 WxUserInfo findWxUserInfoByOpenId(String openId);
 //注册用户
 int insertUserInfo(WxUserInfo userInfo);
 //更新用户信息
 int updataUserInfo(WxUserInfo userInfo);
}
