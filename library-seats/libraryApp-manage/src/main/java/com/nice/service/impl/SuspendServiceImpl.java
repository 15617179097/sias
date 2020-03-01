package com.nice.service.impl;

import com.nice.mapper.SuspendMapper;
import com.nice.pojo.Suspend;
import com.nice.service.SuspendService;
import com.nice.utils.DataResult;
import com.nice.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SuspendServiceImpl implements SuspendService {
    @Autowired
    private SuspendMapper suspendMapper;


    @Override
    public DataResult insertSuspend(Integer subscribeId, Integer time) {
        Suspend suspend=new Suspend();
        long lon = new Date().getTime() + time * 60 * 1000;
        String endTime= DateUtil.DateToString(new Date(lon));
        suspend.setSubscribeId(subscribeId);
        suspend.setEndTime(endTime);
        suspend.setSuspendTime(DateUtil.getStringTime());
        suspend.setState(0);
        try {
            suspendMapper.insertSuspend(suspend);
        }catch (Exception e){
            return DataResult.fail(500,"错误",e);
        }

        return DataResult.ok();
    }
}
