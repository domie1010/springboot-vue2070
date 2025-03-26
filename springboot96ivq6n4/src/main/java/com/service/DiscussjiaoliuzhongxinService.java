package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiaoliuzhongxinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiaoliuzhongxinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiaoliuzhongxinView;


/**
 * 交流中心评论表
 *
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface DiscussjiaoliuzhongxinService extends IService<DiscussjiaoliuzhongxinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiaoliuzhongxinVO> selectListVO(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
   	
   	DiscussjiaoliuzhongxinVO selectVO(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
   	
   	List<DiscussjiaoliuzhongxinView> selectListView(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
   	
   	DiscussjiaoliuzhongxinView selectView(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);

   	

}

