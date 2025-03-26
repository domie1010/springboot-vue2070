package com.dao;

import com.entity.DiscussjiaoliuzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiaoliuzhongxinVO;
import com.entity.view.DiscussjiaoliuzhongxinView;


/**
 * 交流中心评论表
 * 
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface DiscussjiaoliuzhongxinDao extends BaseMapper<DiscussjiaoliuzhongxinEntity> {
	
	List<DiscussjiaoliuzhongxinVO> selectListVO(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
	
	DiscussjiaoliuzhongxinVO selectVO(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
	
	List<DiscussjiaoliuzhongxinView> selectListView(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);

	List<DiscussjiaoliuzhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);

	
	DiscussjiaoliuzhongxinView selectView(@Param("ew") Wrapper<DiscussjiaoliuzhongxinEntity> wrapper);
	

}
