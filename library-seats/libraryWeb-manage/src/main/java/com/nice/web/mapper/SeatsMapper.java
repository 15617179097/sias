package com.nice.web.mapper;

import com.nice.web.pojo.Seats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-08 13:13
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface SeatsMapper {
    //查询以及预约的座位数据
    List<Map<String, Object>> findSeatsByClassRoomId(@Param("classroomId") Integer classroomId);
    //增加座位
    public void insertSeats(Seats seats);
    //删除座位
    public void deleteSeates(Integer id);

    //updateSeatesState
    int updateSeatesState(@Param("state")Integer state,@Param("id")Integer id);

}
