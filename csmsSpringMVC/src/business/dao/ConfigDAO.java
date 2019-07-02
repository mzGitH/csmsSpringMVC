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
