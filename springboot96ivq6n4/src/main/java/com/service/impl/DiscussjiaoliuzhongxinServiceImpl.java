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


import com.dao.DiscussjiaoliuzhongxinDao;
import com.entity.DiscussjiaoliuzhongxinEntity;
import com.service.DiscussjiaoliuzhongxinService;
import com.entity.vo.DiscussjiaoliuzhongxinVO;
import com.entity.view.DiscussjiaoliuzhongxinView;

@Service("discussjiaoliuzhongxinService")
public class DiscussjiaoliuzhongxinServiceImpl extends ServiceImpl<DiscussjiaoliuzhongxinDao, DiscussjiaoliuzhongxinEntity> implements DiscussjiaoliuzhongxinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiaoliuzhongxinEntity> page = this.selectPage(
                new Query<DiscussjiaoliuzhongxinEntity>(params).getPage(),
                new EntityWrapper<DiscussjiaoliuzhongxinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiaoliuzhongxinEntity> wrapper) {
		  Page<DiscussjiaoliuzhongxinView> page =new Query<DiscussjiaoliuzhongxinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussjiaoliuzhongxinVO> selectListVO(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiaoliuzhongxinVO selectVO(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiaoliuzhongxinView> selectListView(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiaoliuzhongxinView selectView(Wrapper<DiscussjiaoliuzhongxinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
