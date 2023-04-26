package com.ruoyi.cl.service;

import java.util.List;
import com.ruoyi.cl.domain.PictureMedia;

/**
 * 图片管理Service接口
 * 
 * @author zqn
 * @date 2023-04-26
 */
public interface IPictureMediaService 
{
    /**
     * 查询图片管理
     * 
     * @param id 图片管理主键
     * @return 图片管理
     */
    public PictureMedia selectPictureMediaById(Long id);

    /**
     * 查询图片管理列表
     * 
     * @param pictureMedia 图片管理
     * @return 图片管理集合
     */
    public List<PictureMedia> selectPictureMediaList(PictureMedia pictureMedia);

    /**
     * 新增图片管理
     * 
     * @param pictureMedia 图片管理
     * @return 结果
     */
    public int insertPictureMedia(PictureMedia pictureMedia);

    /**
     * 修改图片管理
     * 
     * @param pictureMedia 图片管理
     * @return 结果
     */
    public int updatePictureMedia(PictureMedia pictureMedia);

    /**
     * 批量删除图片管理
     * 
     * @param ids 需要删除的图片管理主键集合
     * @return 结果
     */
    public int deletePictureMediaByIds(Long[] ids);

    /**
     * 删除图片管理信息
     * 
     * @param id 图片管理主键
     * @return 结果
     */
    public int deletePictureMediaById(Long id);
}
