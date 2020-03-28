package com.nice.service.impl;

import com.nice.mapper.SupervisionMapper;
import com.nice.pojo.Supervision;
import com.nice.service.SupervisionService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Company: 监督座位 <br>
 * Description:  <br>
 * Date: 2020-03-28 20:42
 *
 * @author wmj
 * @version 1.0
 */
@Service
public class SupervisionServiceImpl implements SupervisionService {

    @Autowired
    private SupervisionMapper supervisionMapper;
    /** 监督信息添加
     * @Description
     * @param supervision
     * @return com.nice.utils.DataResult
     **/
    @Override
    public DataResult insertSupervision(Supervision supervision, HttpServletRequest request) {
        supervision.setUserId((Integer) request.getAttribute("userId"));
        supervisionMapper.insertSupervision(supervision);
        return DataResult.ok();
    }
}
