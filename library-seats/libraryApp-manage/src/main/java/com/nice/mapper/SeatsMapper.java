package com.nice.mapper;

import com.nice.pojo.Seats;
import org.apache.ibatis.annotations.Mapper;
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
public interface SeatsMapper {
    public List<Seats> findSeats(Seats seats);
    public List<Map<String,Object>> findSeatsMap(Seats seats);
}
