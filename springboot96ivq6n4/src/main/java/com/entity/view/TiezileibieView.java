package com.entity.view;

import com.entity.TiezileibieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 帖子类别
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-02-13 12:37:31
 */
@TableName("tiezileibie")
public class TiezileibieView  extends TiezileibieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TiezileibieView(){
	}
 
 	public TiezileibieView(TiezileibieEntity tiezileibieEntity){
 	try {
			BeanUtils.copyProperties(this, tiezileibieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
