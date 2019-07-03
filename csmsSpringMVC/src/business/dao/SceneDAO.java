package business.dao;

import java.util.List;

import model.TScene;
import model.VScene;
import model.VScoreSignIn;

/**
 * 比赛场次信息接口类
 * 
 * @author Administrator
 *
 */
public interface SceneDAO {
	/**
	 * 添加场次比赛人员信息
	 * 
	 * @param scene
	 *            场次信息对象
	 * @return 操作结果，true为成功，false为失败
	 */
	public boolean insert(TScene scene);

	/**
	 * 獲取所有場次信息
	 * 
	 * @return
	 */
	public List<VScene> seleScenes();

	/**
	 * 根據賬號獲取對應的場次信息
	 * 
	 * @param userid
	 *            用戶id
	 * @return
	 */
	public List<VScene> seleScenes(String userid);

	/**
	 * 根據賬號獲取未安排的報名項目
	 * 
	 * @param userid
	 *            用戶id
	 * @return
	 */
	public List<VScene> seleOtherScenes(String userid);

	/**
	 * 获取已比赛完成项目
	 * 
	 * @param wherecondition
	 * @param page
	 * @param limit
	 * @return
	 */
	public List<VScoreSignIn> selectByPageFinish(String wherecondition,
			int page, int limit);

	/**
	 * 获取已比赛完成项目数量
	 * 
	 * @param wherecondition
	 * @return
	 */
	public int selectByPageFinishCount(String wherecondition);

	/**
	 * 通过场次id获取该场次人员
	 * 
	 * @param arrid
	 * @return
	 */
	public List<VScene> getSceneUser(int arrid);

	/**
	 * 添加比赛信息
	 * 
	 * @return
	 */
	public boolean insertScene(List<Object> list);
}
