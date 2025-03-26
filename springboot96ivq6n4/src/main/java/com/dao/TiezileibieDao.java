package com.dao;

import com.entity.TiezileibieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TiezileibieVO;
import com.entity.view.TiezileibieView;


/**
 * 帖子类别
 * 
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
public interface TiezileibieDao extends BaseMapper<TiezileibieEntity> {
	
	List<TiezileibieVO> selectListVO(@Param("ew") Wrapper<TiezileibieEntity> wrapper);
	
	TiezileibieVO selectVO(@Param("ew") Wrapper<TiezileibieEntity> wrapper);
	
	List<TiezileibieView> selectListView(@Param("ew") Wrapper<TiezileibieEntity> wrapper);

	List<TiezileibieView> selectListView(Pagination page,@Param("ew") Wrapper<TiezileibieEntity> wrapper);

	
	TiezileibieView selectView(@Param("ew") Wrapper<TiezileibieEntity> wrapper);
	

}
