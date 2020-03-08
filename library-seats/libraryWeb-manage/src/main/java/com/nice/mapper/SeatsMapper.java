package com.nice.mapper;

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

    List<Map<String, Object>> findSeatsByClassRoomId(@Param("classroomId") Integer classroomId);
}
