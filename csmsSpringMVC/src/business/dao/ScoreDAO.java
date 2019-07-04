package business.dao;

import java.util.List;

import model.TScore;
import model.VScore;

/**
 * �����ɼ�ҵ��ӿ���
 * 
 * @author Administrator
 *
 */
public interface ScoreDAO {
	/**
	 * ��ӳɼ���Ϣ
	 * 
	 * @param score
	 *            �ɼ�����
	 * @return ��ӽ����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(List<Object> list);

	/**
	 * ���³ɼ�����
	 * 
	 * @param score
	 *            �ɼ�����
	 * @return ���½����trueΪ�ɹ���falseΪʧ��
	 */
	public boolean update(TScore score);

	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * 
	 * @param userid
	 *            �û�id
	 * @return �û��ɼ��б�
	 */
	public List<VScore> getByUser(String userid);

	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * 
	 * @param collegeid
	 *            ѧԺid
	 * @return ѧԺ�ɼ��б�
	 */
	public List<VScore> getByCollege(int collegeid);

	/**
	 * ��ѯ�û�����ϸ�ɼ��б�
	 * 
	 * @param classid
	 *            �༶id
	 * @return �༶�ɼ��б�
	 */
	public List<VScore> getByClass(int classid);

	/**
	 * ��ѯ����ѧԺ�ĳɼ�����
	 * 
	 * @return �ɼ��б�
	 */
	public List<VScore> getCollegeScoreOrder();

	/**
	 * ��ѯ�ɼ��б�
	 * 
	 * @param strwhere
	 *            ��ѯ������Ϊ��ʱ��дΪ""��
	 * @param startPage
	 *            ��ȡ��ҳ������
	 * @param limit
	 *            ÿҳ�ļ�¼��
	 * @return �ɼ��б�
	 */
	public List<VScore> getScoreByPage(String strwhere, int startPage, int limit);

	/**
	 * ��ѯָ����Ŀ�ĸ������ɼ��б�
	 * 
	 * @param proid
	 *            ��Ŀid
	 * @return �ɼ��б�
	 */
	public List<VScore> getScoreByProSingle(int proid);

	/**
	 * ��ѯָ����Ŀ���������ɼ��б�
	 * 
	 * @param proid
	 *            ��Ŀid
	 * @return �ɼ��б�
	 */
	public List<VScore> getScoreByProTeam(int proid);

	/**
	 * ��ѯ�ɼ��б�
	 * 
	 * @param strwhere
	 *            ��ѯ������Ϊ��ʱ��дΪ""��
	 * @param startPage
	 *            ��ȡ��ҳ������
	 * @param limit
	 *            ÿҳ�ļ�¼��
	 * @return �ɼ��б�
	 */
	public List<VScore> getScore(String strwhere);

	/**
	 * ��ѯ�ɼ��ܼ�¼��
	 * 
	 * @param strwhere
	 *            ��ѯ������Ϊ��ʱ��дΪ""��
	 * @return �ɼ��б�
	 */
	public int allScoreCount(String strwhere);

	/**
	 * ���ݱ���id�ж��Ƿ��Ѿ�¼��ɼ�
	 * 
	 * @param matchid
	 * @return
	 */
	public TScore isInScore(int matchid);
}
