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


import com.dao.JiaoliuzhongxinDao;
import com.entity.JiaoliuzhongxinEntity;
import com.service.JiaoliuzhongxinService;
import com.entity.vo.JiaoliuzhongxinVO;
import com.entity.view.JiaoliuzhongxinView;

@Service("jiaoliuzhongxinService")
public class JiaoliuzhongxinServiceImpl extends ServiceImpl<JiaoliuzhongxinDao, JiaoliuzhongxinEntity> implements JiaoliuzhongxinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoliuzhongxinEntity> page = this.selectPage(
                new Query<JiaoliuzhongxinEntity>(params).getPage(),
                new EntityWrapper<JiaoliuzhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoliuzhongxinEntity> wrapper) {
		  Page<JiaoliuzhongxinView> page =new Query<JiaoliuzhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JiaoliuzhongxinVO> selectListVO(Wrapper<JiaoliuzhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiaoliuzhongxinVO selectVO(Wrapper<JiaoliuzhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiaoliuzhongxinView> selectListView(Wrapper<JiaoliuzhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoliuzhongxinView selectView(Wrapper<JiaoliuzhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
