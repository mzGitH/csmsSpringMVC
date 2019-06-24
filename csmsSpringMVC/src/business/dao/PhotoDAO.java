package business.dao;

import model.TPhoto;

public interface PhotoDAO {
	/**
	 * ����ͼƬ��Դ��Ż��ͼƬ����
	 * @param id ͼƬ��Դ���
	 * @return ͼƬ��Դ����
	 */
	public TPhoto getPhotoById(int id);
	
	/**
	 * �����ݿ������һ��ͼƬ��Դ��¼
	 * @param TPhoto obj ͼƬ��Դ����
	 * @return int �ɹ�����ͼƬ��Դ������key��ʧ�ܷ���0
	 */
	public boolean addPhoto(TPhoto obj);
	
	/**
	 * ��ָ��һ��ͼƬ��Դɾ��
	 * @param id ��Ҫɾ����ͼƬ��Դ���
	 * @return boolean �ɹ�����true�� ʧ�ܷ���false
	 */
	public boolean deletePhoto(int id);
}
