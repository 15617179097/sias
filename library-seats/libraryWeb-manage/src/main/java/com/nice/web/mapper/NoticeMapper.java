package com.nice.web.mapper;

import com.nice.web.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:37
 */
@Component
@Mapper
public interface NoticeMapper {
    //添加公告
    public void addNotice(Notice notice);
    //删除公告
    public void deleteNotice(Integer id);

}
