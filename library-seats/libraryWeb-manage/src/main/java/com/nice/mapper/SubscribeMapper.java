package com.nice.mapper;

import com.nice.pojo.Subscribe;
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
public interface SubscribeMapper {

    //获取今天或者明天 已经预约过的座位
    public List<Subscribe> findSubscribeSeats(@Param("time") String time, @Param("endTime") String endTime,@Param("classroomId")Integer classroomId, @Param("createTime") String createTime);

    //预约座位
    public int insertSubscribe(Subscribe subscribe);
}
