package com.nice.service;

import com.nice.pojo.Admin;
import com.nice.utils.DataResult;

/**
 * @ClassName AdminService
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
public interface AdminService {
    DataResult adminLogin(Admin admin);
}
