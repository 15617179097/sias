package com.nice.web.controller;

import com.nice.web.pojo.Notice;

import com.nice.web.service.NoticeService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author msl
 * @version 1.0
 * @date 2020/3/13 14:03
 */
@RestController
@RequestMapping("/Notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //添加公告
    @RequestMapping("addNotice")
    public DataResult addNotice(Notice notice){
        return DataResult.ok(noticeService.addNotice(notice));
    }
    //删除公告
    @RequestMapping("deleteNotice/{id}")
    public DataResult deleteNotice(@PathVariable("id") Integer id){
        return DataResult.ok(noticeService.deleteNotice(id));
    }
}
