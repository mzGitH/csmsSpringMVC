package business.dao;

import java.util.List;

import model.TScene;
import model.VScene;
import model.VScoreSignIn;

/**
 * ����������Ϣ�ӿ���
 * 
 * @author Administrator
 *
 */
public interface SceneDAO {
	/**
	 * ��ӳ��α�����Ա��Ϣ
	 * 
	 * @param scene
	 *            ������Ϣ����
	 * @return ���������trueΪ�ɹ���falseΪʧ��
	 */
	public boolean insert(TScene scene);

	/**
	 * �@ȡ���Ј�����Ϣ
	 * 
	 * @return
	 */
	public List<VScene> seleScenes();

	/**
	 * �����~̖�@ȡ�����Ĉ�����Ϣ
	 * 
	 * @param userid
	 *            �Ñ�id
	 * @return
	 */
	public List<VScene> seleScenes(String userid);

	/**
	 * �����~̖�@ȡδ���ŵĈ����Ŀ
	 * 
	 * @param userid
	 *            �Ñ�id
	 * @return
	 */
	public List<VScene> seleOtherScenes(String userid);

	/**
	 * ��ȡ�ѱ��������Ŀ
	 * 
	 * @param wherecondition
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<VScoreSignIn> selectByPageFinish(String wherecondition,
			int page, int limit);

	/**
	 * ��ȡ�ѱ��������Ŀ����
	 * 
	 * @param wherecondition
	 * @return
	 */
	public int selectByPageFinishCount(String wherecondition);

	/**
	 * ͨ������id��ȡ�ó�����Ա
	 * 
	 * @param arrid
	 * @return
	 */
	public List<VScene> getSceneUser(int arrid);

	/**
	 * ��ӱ�����Ϣ
	 * 
	 * @return
	 */
	public boolean insertScene(List<Object> list);
}
