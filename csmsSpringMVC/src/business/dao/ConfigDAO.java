package business.dao;

import java.util.List;

import model.TConfig;

public interface ConfigDAO {
	/**
	 * 根据获取所有运动会信息
	 * 
	 * @return Config
	 */
	public List<TConfig> getTConfig();

	/**
	 * 根据获取当届运动会信息
	 * 
	 * @return Config
	 */
	public TConfig getNowTConfig();
	

	/**
	 * 根据获取最新一届运动会信息
	 * 
	 * @return Config
	 */
	public TConfig getNewTConfig();

	/**
	 * 获取所有运动会信息
	 * 
	 * @return
	 */
	public List<TConfig> getAllConfig();

	/**
	 * 根据运动会id获取所有运动会信息
	 * 
	 * @return
	 */
	public List<TConfig> getAllConfigByid(int sportid);
}
