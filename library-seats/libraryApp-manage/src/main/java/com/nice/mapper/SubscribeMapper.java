package com.nice.mapper;

import com.nice.pojo.Subscribe;
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
public interface SubscribeMapper {
    public List<Subscribe> findAllSubscribe(Subscribe subscribe);
    //预约记录
    public int saveSubscribe(Subscribe subscribe);
    //查询明天已经预约 或者今天到了结束时间的预约
    public List<Subscribe>  findSubscribe(@Param("tomorrowCreateTime") String tomorrowCreateTime, @Param("tomorrowEndTime") String tomorrowEndTime, @Param("createTime") String createTime, @Param("userId") Integer userId);
    //查询我的预约
    public Map<String,Object> findMySubscribe(@Param("userId") Integer userId);
    //查询我的历史预约
    public List<Map<String,Object>>  findMyAllSubscribe(@Param("userId") Integer userId);
    //取消预约
    public int delSubscribe(@Param("subscribeId") Integer subscribeId, @Param("endTime") String endTime, @Param("state") Integer state);

}
