package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TiezileibieEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TiezileibieVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TiezileibieView;


/**
 * 帖子类别
 *
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface TiezileibieService extends IService<TiezileibieEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TiezileibieVO> selectListVO(Wrapper<TiezileibieEntity> wrapper);
   	
   	TiezileibieVO selectVO(@Param("ew") Wrapper<TiezileibieEntity> wrapper);
   	
   	List<TiezileibieView> selectListView(Wrapper<TiezileibieEntity> wrapper);
   	
   	TiezileibieView selectView(@Param("ew") Wrapper<TiezileibieEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TiezileibieEntity> wrapper);

   	

}

