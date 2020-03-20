package com.nice.web.mapper;

import com.nice.web.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

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

    //根据id查询单个公告
    public List<Notice> selectANotice(Integer id);
    //查询所有公告信息
    public List<Notice> findAllNotice();
    //分页查询公告
    public List<Map<String,Object>> findNotice(Notice notice);
}