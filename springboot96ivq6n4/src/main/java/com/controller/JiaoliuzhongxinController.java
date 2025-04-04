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

import com.entity.JiaoliuzhongxinEntity;
import com.entity.view.JiaoliuzhongxinView;

import com.service.JiaoliuzhongxinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 交流中心
 * 后端接口
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
@RestController
@RequestMapping("/jiaoliuzhongxin")
public class JiaoliuzhongxinController {
    @Autowired
    private JiaoliuzhongxinService jiaoliuzhongxinService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoliuzhongxinEntity jiaoliuzhongxin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiaoliuzhongxin.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiaoliuzhongxinEntity> ew = new EntityWrapper<JiaoliuzhongxinEntity>();

		PageUtils page = jiaoliuzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoliuzhongxin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoliuzhongxinEntity jiaoliuzhongxin, 
		HttpServletRequest request){
        EntityWrapper<JiaoliuzhongxinEntity> ew = new EntityWrapper<JiaoliuzhongxinEntity>();

		PageUtils page = jiaoliuzhongxinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoliuzhongxin), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoliuzhongxinEntity jiaoliuzhongxin){
       	EntityWrapper<JiaoliuzhongxinEntity> ew = new EntityWrapper<JiaoliuzhongxinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoliuzhongxin, "jiaoliuzhongxin")); 
        return R.ok().put("data", jiaoliuzhongxinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoliuzhongxinEntity jiaoliuzhongxin){
        EntityWrapper< JiaoliuzhongxinEntity> ew = new EntityWrapper< JiaoliuzhongxinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoliuzhongxin, "jiaoliuzhongxin")); 
		JiaoliuzhongxinView jiaoliuzhongxinView =  jiaoliuzhongxinService.selectView(ew);
		return R.ok("查询交流中心成功").put("data", jiaoliuzhongxinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoliuzhongxinEntity jiaoliuzhongxin = jiaoliuzhongxinService.selectById(id);
        return R.ok().put("data", jiaoliuzhongxin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoliuzhongxinEntity jiaoliuzhongxin = jiaoliuzhongxinService.selectById(id);
        return R.ok().put("data", jiaoliuzhongxin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiaoliuzhongxinEntity jiaoliuzhongxin = jiaoliuzhongxinService.selectById(id);
        if(type.equals("1")) {
        	jiaoliuzhongxin.setThumbsupnum(jiaoliuzhongxin.getThumbsupnum()+1);
        } else {
        	jiaoliuzhongxin.setCrazilynum(jiaoliuzhongxin.getCrazilynum()+1);
        }
        jiaoliuzhongxinService.updateById(jiaoliuzhongxin);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoliuzhongxinEntity jiaoliuzhongxin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaoliuzhongxin);
        jiaoliuzhongxinService.insert(jiaoliuzhongxin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoliuzhongxinEntity jiaoliuzhongxin, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jiaoliuzhongxin);
        jiaoliuzhongxinService.insert(jiaoliuzhongxin);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoliuzhongxinEntity jiaoliuzhongxin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoliuzhongxin);
        jiaoliuzhongxinService.updateById(jiaoliuzhongxin);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoliuzhongxinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
