package com.dao;

import com.entity.JiaoliuzhongxinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiaoliuzhongxinVO;
import com.entity.view.JiaoliuzhongxinView;


/**
 * 交流中心
 * 
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface JiaoliuzhongxinDao extends BaseMapper<JiaoliuzhongxinEntity> {
	
	List<JiaoliuzhongxinVO> selectListVO(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);
	
	JiaoliuzhongxinVO selectVO(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);
	
	List<JiaoliuzhongxinView> selectListView(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);

	List<JiaoliuzhongxinView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);

	
	JiaoliuzhongxinView selectView(@Param("ew") Wrapper<JiaoliuzhongxinEntity> wrapper);
	

}
