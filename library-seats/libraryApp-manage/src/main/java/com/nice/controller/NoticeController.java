package com.nice.controller;

import com.nice.service.NoticeService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 14:38
 *
 * @author wmj
 * @version 1.0
 */
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;
    @GetMapping("notice")
    public DataResult findNotice(@RequestParam(value = "pagenum",defaultValue = "1") int pagenum,
                                 @RequestParam(value = "pagesize",defaultValue = "10") int pagesize){
        return noticeService.findNotice(pagenum,pagesize);
    }

}
