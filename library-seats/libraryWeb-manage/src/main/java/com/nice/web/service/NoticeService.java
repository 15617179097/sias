package com.nice.web.service;

import com.nice.web.pojo.Notice;
import com.nice.web.utils.DataResult;

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
}
