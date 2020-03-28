package com.nice.mapper;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 14:41
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface NoticeMapper {

    //分页查询公告
    List<Map<String, Object>> findNotice(@Param("title")String title);
}
