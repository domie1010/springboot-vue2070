package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.TiezileibieDao;
import com.entity.TiezileibieEntity;
import com.service.TiezileibieService;
import com.entity.vo.TiezileibieVO;
import com.entity.view.TiezileibieView;

@Service("tiezileibieService")
public class TiezileibieServiceImpl extends ServiceImpl<TiezileibieDao, TiezileibieEntity> implements TiezileibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TiezileibieEntity> page = this.selectPage(
                new Query<TiezileibieEntity>(params).getPage(),
                new EntityWrapper<TiezileibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TiezileibieEntity> wrapper) {
		  Page<TiezileibieView> page =new Query<TiezileibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TiezileibieVO> selectListVO(Wrapper<TiezileibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TiezileibieVO selectVO(Wrapper<TiezileibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TiezileibieView> selectListView(Wrapper<TiezileibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TiezileibieView selectView(Wrapper<TiezileibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
