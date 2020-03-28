package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.NoticeMapper;
import com.nice.service.NoticeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 14:40
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;
    /**
     * @Description 分页查询公告
     * @param pagenum
     * @param pagesize
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findNotice(int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> notice = noticeMapper.findNotice(null);
        PageInfo<Map<String, Object>> info = new PageInfo<>(notice);
        Map<String,Object> map = new HashMap<>();
        map.put("total",info.getPages());
        map.put("notice",info.getList());
        return DataResult.ok(map);    }
}
