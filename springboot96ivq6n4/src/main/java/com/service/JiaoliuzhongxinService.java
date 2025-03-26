package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoliuzhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiaoliuzhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoliuzhongxinView;


/**
 * 交流中心
 *
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface JiaoliuzhongxinService extends IService<JiaoliuzhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoliuzhongxinVO> selectListVO(Wrapper<JiaoliuzhongxinEntity> wrapper);
   	
   	JiaoliuzhongxinVO selectVO(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);
   	
   	List<JiaoliuzhongxinView> selectListView(Wrapper<JiaoliuzhongxinEntity> wrapper);
   	
   	JiaoliuzhongxinView selectView(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoliuzhongxinEntity> wrapper);

   	

}

