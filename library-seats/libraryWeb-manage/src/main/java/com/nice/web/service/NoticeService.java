package com.nice.web.service;

import com.nice.web.pojo.Notice;
import com.nice.web.utils.DataResult;
import org.springframework.ui.Model;


/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:44
 */
public interface NoticeService {
    //添加公告
    DataResult addNotice(Notice notice);
    //删除公告
    DataResult deleteNotice(Integer id);
    //根据id查询单个公告
    DataResult selectANotice(Integer id);
    //查询所有公告信息
    DataResult findAllNotice();
    //分页查询公告
    DataResult noticeList(String title,Integer pagenum,Integer pagesize);
    //修改公告
    DataResult updateNotice(Integer id,Notice notice);
}
