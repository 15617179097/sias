package com.nice.mapper;

import com.nice.pojo.Supervision;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 20:44
 *
 * @author wmj
 * @version 1.0
 */
@Component
@Mapper
public interface SupervisionMapper {

    //添加监督座位信息
    int insertSupervision(Supervision supervision);
}
