package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TiezileibieEntity;
import com.entity.view.TiezileibieView;

import com.service.TiezileibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 帖子类别
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
@RestController
@RequestMapping("/tiezileibie")
public class TiezileibieController {
    @Autowired
    private TiezileibieService tiezileibieService;




    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TiezileibieEntity tiezileibie,
		HttpServletRequest request){
        EntityWrapper<TiezileibieEntity> ew = new EntityWrapper<TiezileibieEntity>();

		PageUtils page = tiezileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiezileibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TiezileibieEntity tiezileibie, 
		HttpServletRequest request){
        EntityWrapper<TiezileibieEntity> ew = new EntityWrapper<TiezileibieEntity>();

		PageUtils page = tiezileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiezileibie), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TiezileibieEntity tiezileibie){
       	EntityWrapper<TiezileibieEntity> ew = new EntityWrapper<TiezileibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tiezileibie, "tiezileibie")); 
        return R.ok().put("data", tiezileibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TiezileibieEntity tiezileibie){
        EntityWrapper< TiezileibieEntity> ew = new EntityWrapper< TiezileibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tiezileibie, "tiezileibie")); 
		TiezileibieView tiezileibieView =  tiezileibieService.selectView(ew);
		return R.ok("查询帖子类别成功").put("data", tiezileibieView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TiezileibieEntity tiezileibie = tiezileibieService.selectById(id);
        return R.ok().put("data", tiezileibie);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TiezileibieEntity tiezileibie = tiezileibieService.selectById(id);
        return R.ok().put("data", tiezileibie);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TiezileibieEntity tiezileibie, HttpServletRequest request){
        if(tiezileibieService.selectCount(new EntityWrapper<TiezileibieEntity>().eq("tiezileibie", tiezileibie.getTiezileibie()))>0) {
            return R.error("帖子类别已存在");
        }
    	//ValidatorUtils.validateEntity(tiezileibie);
        tiezileibieService.insert(tiezileibie);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TiezileibieEntity tiezileibie, HttpServletRequest request){
        if(tiezileibieService.selectCount(new EntityWrapper<TiezileibieEntity>().eq("tiezileibie", tiezileibie.getTiezileibie()))>0) {
            return R.error("帖子类别已存在");
        }
    	//ValidatorUtils.validateEntity(tiezileibie);
        tiezileibieService.insert(tiezileibie);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TiezileibieEntity tiezileibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tiezileibie);
        if(tiezileibieService.selectCount(new EntityWrapper<TiezileibieEntity>().ne("id", tiezileibie.getId()).eq("tiezileibie", tiezileibie.getTiezileibie()))>0) {
            return R.error("帖子类别已存在");
        }
        tiezileibieService.updateById(tiezileibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tiezileibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
