package business.dao;

import java.util.List;

import model.VClassScore;


/**
 * �༶�ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreClassesDAO {
	/**
	 * ��ȡĳ���༶�ĳɼ���Ϣ
	 * @param classid �༶id
	 * @return �༶�ɼ���Ϣ
	 */
	public VClassScore getByClassid(int classid);
	/**
	 * ��ѯ���а༶�ɼ�
	 * @return List<VClass>���ݼ�
	 */
	public List<VClassScore> getAllScoreClasses();
	/**
	 * ��ҳ��ѯ�༶�ɼ�
	 * @param strwhere ��ѯ������Ϊ������дΪ""��
	 * @param startPage ��ȡ��ҳ������
	 * @param pagesize ÿҳ�ļ�¼��
	 * @return
	 */
	public List<VClassScore> getAllScoreByPage(String strwhere,int startPage,int pagesize);
	/**
	 * ��ȡ���а༶�ɼ�����
	 * @param strwhere ��ѯ������Ϊ������дΪ""��
	 * @return
	 */
	public int allScoreCount(String strwhere);
	/**
	 * ��ȡĳ���༶���ܷ�
	 * @param classid �༶id
	 * @return
	 */
	public double allScore(int classid);
	/**
	 * ��ȡĳ���༶��ƽ����
	 * @param classid �༶id
	 * @return
	 */
	public double avgScore(int classid);
}
