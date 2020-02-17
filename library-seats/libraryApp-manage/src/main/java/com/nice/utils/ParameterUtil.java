package com.nice.utils;

import com.nice.pojo.UserInfo;
import org.apache.commons.lang3.StringUtils;

/**
 * Company:  <br>
 * Description:  <br>
 * Date: 2020-01-24 14:58
 *
 * @author wmj
 * @version 1.0
 */
public class ParameterUtil {
    public static boolean registerPd(UserInfo user){
        if (user.getId()!=null&&!StringUtils.isBlank(user.getName())&&!StringUtils.isBlank(user.getPassword())&&!StringUtils.isBlank(user.getPhone())){
            return true;
        }
        return  false;
    }
}
