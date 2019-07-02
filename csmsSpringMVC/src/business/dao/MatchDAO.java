package business.dao;

import java.util.List;

import model.TMatch;
import model.VMatch;

/**
 * ��������ҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface MatchDAO {
	/**
	 * ��ӱ���������Ϣ
	 * 
	 * @param match
	 *            ��������
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TMatch match);

	/**
	 * �ж��Ƿ񱨹��ı���
	 * 
	 * @param userid
	 *            �û�id
	 * @param proid
	 *            ��Ŀid
	 * @return ���������trueΪ�ѱ�����falseΪδ����
	 */
	public boolean isSignUp(String userid, int proid);

	/**
	 * �����û�id��ѯ���������б�
	 * 
	 * @param userid
	 *            �û�id
	 * @return ���������б�
	 */
	public List<VMatch> selectByUser(String userid);

	/**
	 * ��ѯ���������б�
	 * 
	 * @return ���������б�
	 */
	public List<VMatch> select();

	/**
	 * ��ҳ��ѯ���������б�
	 * 
	 * @param startPage
	 *            ��ǰҳ
	 * @param pageSize
	 *            ÿҳ��¼��
	 * @return ���������б�
	 */
	public List<VMatch> selectByPage(String wherecondition, int startPage,
			int pageSize);

	/**
	 * ��ȡ�ܼ�¼��
	 * 
	 * @return �ܼ�¼��
	 */
	public int getPageCount(String wherecondition);

	/**
	 * ��ȡ�������
	 * 
	 * @return ���ݼ�
	 */
	public List<VMatch> selectAll();

	/**
	 * �ж��û��Ƿ��Ѿ���������Ŀ
	 * 
	 * @param proid
	 * @param userid
	 * @return
	 */
	public int countUser(int proid, String userid);
}
