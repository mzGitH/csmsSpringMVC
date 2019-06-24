package business.dao;

import java.sql.ResultSet;
import java.util.List;

import model.VCollegeScore;

/**
 * ѧԺ�ɼ�ҵ��ӿ���
 * @author jock
 *
 */
public interface ScoreCollegeDAO {
	/**
	 * 
	 * @param collegeid ѧԺid
	 * @return ѧԺ�ɼ���Ϣ
	 */
	public VCollegeScore getByCollegeid(int collegeid);
	/**
	 * ��ѯ����ѧԺ�ɼ�
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<VCollegeScore> getAllCollegeScore();
	/**
	 * ��ҳ��ѯ����ѧԺ�ɼ�
	 * @param strwhere ��ѯ������Ϊ����дΪ""��
	 * @param startPage ��ǰҳ
	 * @param pageSize ÿҳ��ʾ����
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<VCollegeScore> getAllScoreByPage(String strwhere,int startPage,int pageSize);
	
	/**
	
	 */
	/**
	 * ����ѧԺ���Ʋ�ѯѧԺ�ɼ�(��ҳ)
	 * @param cllegeName ѧԺ����
	 * @param pageSize ÿҳ��ʾ����
	 * @param startPage ��ǰҳ
	 * @return List<ScoreCollege>���ݼ�
	 */
	public List<VCollegeScore> getCollegeScoreBypage(String cllegeName,int pageSize,int startPage);
	/**
	 * ��ѯѧԺ�ɼ�
	 * @param collegeName ѧԺ����
	 * @return
	 */
	public List<VCollegeScore> getSearchCollege(String collegeName);
	/**
	 * ��ѯ��ҳ��ҳ��
	 * @param pageSize ÿҳ��ʾ����
	 */
	public int getpageAmount(int pageSize);
	
	/**
	 * ��ѯ����������
	 * @param strwhere ��ѯ������Ϊ����дΪ""��
	 */
	public int geAllCount(String strwhere);
	/**
	 * ��ѯ��ҳ��ҳ������������
	 * @param opraton ����
	 * @param pageSizeÿҳ��ʾ����
	 * @return
	 */
	public int getpageAmountbysearch(String opraton,int pageSize); 
	/**
	 * ��ȡĳ��ѧԺѧ�����ܷ�
	 * @return
	 */
	public double allStuScore(int collegeid);
	/**
	 * ��ȡĳ��ѧԺѧ����ƽ����
	 * @return
	 */
	public double avgStuScore(int collegeid);
	/**
	 * ��ȡĳ��ѧԺ��ʦ���ܷ�
	 * @return
	 */
	public double allTeaScore(int collegeid);
	/**
	 * ��ȡĳ��ѧԺ��ʦ��ƽ����
	 * @return
	 */
	public double avgTeaScore(int collegeid);
}
