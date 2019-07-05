package business.dao;

import java.util.List;

import model.TConfig;

public interface ConfigDAO {
	/**
	 * ���ݻ�ȡ�����˶�����Ϣ
	 * 
	 * @return Config
	 */
	public List<TConfig> getTConfig();

	/**
	 * ���ݻ�ȡ�����˶�����Ϣ
	 * 
	 * @return Config
	 */
	public TConfig getNowTConfig();
	

	/**
	 * ���ݻ�ȡ����һ���˶�����Ϣ
	 * 
	 * @return Config
	 */
	public TConfig getNewTConfig();

	/**
	 * ��ȡ�����˶�����Ϣ
	 * 
	 * @return
	 */
	public List<TConfig> getAllConfig();

	/**
	 * �����˶���id��ȡ�����˶�����Ϣ
	 * 
	 * @return
	 */
	public List<TConfig> getAllConfigByid(int sportid);
}
