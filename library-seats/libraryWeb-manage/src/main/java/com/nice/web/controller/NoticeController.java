package com.nice.web.controller;

import com.nice.web.pojo.Classroom;
import com.nice.web.pojo.Notice;

import com.nice.web.service.NoticeService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("addNotice")
    public DataResult addNotice(Notice notice){
        return noticeService.addNotice(notice);
    }
    //删除公告
    @PostMapping("deleteNotice/{id}")
    public DataResult deleteNotice(@PathVariable("id") Integer id){
        return noticeService.deleteNotice(id);
    }
    //根据id查询单个公告
    @RequestMapping("selectANotice/{id}")
    public DataResult selectANotice(@PathVariable("id") Integer id){
        return noticeService.selectANotice(id);
    }

    //查询所有公告信息
    @RequestMapping("findAllNotice")
    public DataResult findAllNotice(){
        return noticeService.findAllNotice();
    }

    //分页查询公告
    @RequestMapping("findNotice")
    public DataResult findNotice(String query,Integer pagenum,Integer pagesize){
        return noticeService.noticeList(query,pagenum,pagesize);
    }
    //修改公告
    @PostMapping("updateNotice/{id}")
    public DataResult updateNotice(@PathVariable("id") Integer id, Notice notice){
        return noticeService.updateNotice(id,notice);
    }
}
