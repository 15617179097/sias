package com.nice.mapper;

import com.nice.pojo.Classroom;
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
public interface ClassRoomMapper {
    public List<Map<String,Object>> findAllClassRoom(@Param("classroomId") Integer classroomId, @Param("createTime") String createTime, @Param("endTime") String endTime);
    public List<Classroom> findClassRoom();
}
