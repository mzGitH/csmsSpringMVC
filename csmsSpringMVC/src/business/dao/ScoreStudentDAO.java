package business.dao;

import java.util.List;

import model.VScore;
import model.VStudentScore;

/**
 * ���˳ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreStudentDAO {
	/**
	 * 
	 * @param string ѧ���˺�
	 * @return ѧ���ɼ���Ϣ
	 */
	public VStudentScore getByUserid(String string);
	/**
	 * ��ѯĳ��ѧ��/��ʦ�ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 */
	public List<VScore> getScoreStudent(String userid);
	/**
	 * ��ҳ��ѯ����ѧ���ɼ�
	 * @return List<ScoreStudent>���ݼ�
	 * @param strwhere ��ѯ������Ϊ����дΪ""��
	 * @param startPage ��Ҫ��ҳ��������
	 * @param pageSize ÿҳ�ļ�¼��
	 * @return
	 */
	public List<VScore> getAllScoreByPage(String strwhere, int startPage,int pageSize);
	/**
	 * ��ȡĳ��ѧ�����ܷ�
	 * @return
	 */
	public double allScore(String userid);
	/**
	 * ��ȡĳ��ѧ����ƽ����
	 * @return
	 */
	public double avgScore(String userid);
}
