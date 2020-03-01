package com.nice.service.impl;

import com.nice.mapper.ModularMapper;
import com.nice.pojo.Modular;
import com.nice.service.ModularService;
import com.nice.utils.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ModularServiceImpl
 * @Description: TODO
 * @Author wmj
 * @Date 2020/2/29
 * @Version V1.0
 **/
@Service
public class ModularServiceImpl implements ModularService {
    @Autowired
    private ModularMapper modularMapper;

    /*
        查询左侧菜单模板列表
     */
    @Override
    public DataResult findModular() {
        List<Map<String,Object>> modular = modularMapper.findModular();

        List<Map<String,Object>> modularParent= new ArrayList<>();
        List<Map<String,Object>> modularChildren= new ArrayList<>();
        for (Map<String,Object> list : modular){
            if (list.get("mId")==null) {
                modularParent.add(list);
            }else {
                modularChildren.add(list);
            }
        }
        for (Map<String,Object> list : modularParent){
            List<Map<String,Object>>  children= new ArrayList<>();
            for (Map<String,Object> lists : modularChildren){
                String id1 = String.valueOf(list.get("id"));
                String mId1 = String.valueOf(lists.get("mId"));
                if(id1.equals(mId1)){
                    children.add(lists);
                }
            }

            list.put("children",children);
          /*  Map<String,Object> map =new HashMap<>();
            map.put("children",children);
            modularParent.add(map);*/
        }

        return DataResult.ok(modularParent);
    }
}
