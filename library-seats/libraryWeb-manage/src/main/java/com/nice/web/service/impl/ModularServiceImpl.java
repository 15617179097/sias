package com.nice.web.service.impl;

import com.nice.web.utils.DataResult;
import com.nice.web.mapper.ModularMapper;
import com.nice.web.service.ModularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ModularServiceImol
 * @Description: TODO
 * @Author wmj
 * @Date 2020/3/1
 * @Version V1.0
 **/
@Service
public class ModularServiceImpl implements ModularService{

        @Autowired
        private ModularMapper modularMapper;

        /**
         * @Description 查询左侧菜单模板列表
         * @Param
         * @return
         **/
        @Override
        public DataResult findModular() {
            List<Map<String,Object>> modular = modularMapper.findModular();
            // 获取一级菜单模块
            List<Map<String,Object>> modularParent= new ArrayList<>();
            //获取二级菜单模块
            List<Map<String,Object>> modularChildren= new ArrayList<>();
            for (Map<String,Object> list : modular){
                if (list.get("mId")==null) {
                    modularParent.add(list);
                }else {
                    modularChildren.add(list);
                }
            }
            //将二级菜单模块添加到对应一级菜单模块
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
            }
            return DataResult.ok(modularParent);
        }
}
