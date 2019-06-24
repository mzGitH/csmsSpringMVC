package business.dao;

import java.util.List;

import model.TSystemLog;

public interface SystemLogDAO {
	/**
	 * ��ȡ���е���־����
	 */
	public List getAllOperType();

	/**
	 * ����������ȡϵͳ��־�б�
	 * 
	 * @param wherecondition
	 * @return List
	 */
	public List<TSystemLog> getaAllSystemList(String wherecondition, int page,
			int pageSize);

	/**
	 * ����������ȡ����������ϵͳ��־������
	 * 
	 * @param wherecondition
	 *            �磺"userRole = '��������Ա' and userid = 'zhangjs'"
	 * @return
	 */
	public int getSystemLogAmount(String wherecondition);

}
