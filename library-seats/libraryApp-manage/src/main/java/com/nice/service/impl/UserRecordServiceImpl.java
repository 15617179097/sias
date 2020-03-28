package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.mapper.UserRecordMapper;
import com.nice.pojo.UserRecord;
import com.nice.service.UserRecordService;
import com.nice.service.WxUserService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName UserRecordServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/9
 * @Version V1.0
 **/
@Service
public class UserRecordServiceImpl implements UserRecordService {
    @Autowired
    private UserRecordMapper userRecordMapper;
    @Autowired
    private WxUserService wxUserService;

    @Override
    public DataResult findUserRecordByUserId(String loginStateUUID) {

        UserRecord userRecord=new UserRecord();
        userRecord.setUserId( wxUserService.getWxUserId(loginStateUUID));
        List<UserRecord> userRecordByUserId = userRecordMapper.findUserRecordByUserId(userRecord);
        return DataResult.ok(userRecordByUserId);
    }
    /**
     * @Description 查询我的违约记录
     * @param request
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult findUserRecord(HttpServletRequest request,Integer pagenum,Integer pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        Integer userId = (Integer) request.getAttribute("userId");
        List<Map<String, Object>> userRecord = userRecordMapper.findUserRecord(userId);
        PageInfo<Map<String, Object>> info = new PageInfo<>(userRecord);
        Map<String, Object> rel=new HashMap<>();
        rel.put("userRecordList",info.getList());
        rel.put("total",info.getPages());
        return DataResult.ok(rel);
    }
}
