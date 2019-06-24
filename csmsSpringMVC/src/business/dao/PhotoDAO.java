package business.dao;

import model.TPhoto;

public interface PhotoDAO {
	/**
	 * 根据图片资源编号获得图片对象
	 * @param id 图片资源编号
	 * @return 图片资源对象
	 */
	public TPhoto getPhotoById(int id);
	
	/**
	 * 在数据库中添加一条图片资源记录
	 * @param TPhoto obj 图片资源对象
	 * @return int 成功返回图片资源的主键key，失败返回0
	 */
	public boolean addPhoto(TPhoto obj);
	
	/**
	 * 将指定一个图片资源删除
	 * @param id 需要删除的图片资源编号
	 * @return boolean 成功返回true， 失败返回false
	 */
	public boolean deletePhoto(int id);
}
