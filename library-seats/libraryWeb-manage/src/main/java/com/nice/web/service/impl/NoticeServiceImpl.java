package com.nice.web.service.impl;

import com.nice.web.mapper.NoticeMapper;
import com.nice.web.pojo.Notice;
import com.nice.web.service.NoticeService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 13:54
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 添加公告
     * @param notice
     * @return
     */
    @Override
    public DataResult addNotice(Notice notice){
        try {
            noticeMapper.addNotice(notice);
        }catch (Exception e) {
            return DataResult.fail(500, "添加失败！！", e);
        }
        return DataResult.ok(notice);
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @Override
    public DataResult deleteNotice(Integer id){
        try {
            noticeMapper.deleteNotice(id);
        }catch (Exception e){
            return DataResult.fail(500, "删除失败！！", e);
        }
        return DataResult.ok(id);
    }

}
