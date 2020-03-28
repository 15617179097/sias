package com.nice.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.web.mapper.SupervisionMapper;
import com.nice.web.service.SupervisionService;
import com.nice.web.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-03-28 21:33
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class SupervisionServiceImpl implements SupervisionService {
    @Autowired
    private SupervisionMapper supervisionMapper;

    /**
     * @Description 获取监督占位列表
     * @param query state
     * @param pagenum
     * @param pagesize
     * @return com.nice.web.utils.DataResult
     **/
    @Override
    public DataResult findSupervision(String query, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum,pagesize);
        List<Map<String, Object>> supervision = supervisionMapper.findSupervision(query);
        PageInfo<Map<String, Object>> info = new PageInfo<>(supervision);
        Map<String, Object> map = new HashMap<>();
        map.put("supervisionList",info.getList());
        map.put("total",info.getTotal());
        return DataResult.ok(map);
    }

    @Override
    public DataResult updateSupervision(int id) {
        supervisionMapper.updateSupervision(id);
        return DataResult.ok();
    }
}
