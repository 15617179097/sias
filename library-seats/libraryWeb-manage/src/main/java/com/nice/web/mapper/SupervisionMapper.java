package com.nice.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:34
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface SupervisionMapper {

    //查询监督占座列表
    List<Map<String,Object>> findSupervision(@Param("studentId") String studentId);

    //完成处理
    int updateSupervision(@Param("id") int id);
}
