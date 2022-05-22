package com.ewo.admin.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ewo.admin.auth.model.SbMenu;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangruiheng
 */
public interface SbMenuMapper extends BaseMapper<SbMenu> {


    /**
     * 查询用户的所有资源
     * @author wangruiheng
     * @date 2022/05/22 21:54
     * @param userId
     * @return java.lang.String
     */
    String getMenuCodeByUserId(@Param("userId") Long userId);
}