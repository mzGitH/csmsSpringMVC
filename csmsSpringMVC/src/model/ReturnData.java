package model;

/**
 * �洢����layui table���ص�json���ݸ�ʽ
 * @author Administrator
 *
 */
public class ReturnData {
	/**
	 * �ɹ�
	 */
	public static int SUCCESS = 0;
	/**
	 * ʧ��
	 */
	public static int ERROR = 1;
	/**
	 * ����״̬���ɹ���SUCCESS����ʧ�ܣ�ERROR��
	 */
	public int code;
	/**
	 * ��ʾ��Ϣ
	 */
	public String msg;
	/**
	 * ���ݼ�¼��
	 */
	public int count;
	/**
	 * ���ݵ�json�ַ���
	 */
	public Object data;
	/**
	 * ���ݵ�json�ַ���
	 */
	public Object data1;
	/**
	 * �ܳɼ�
	 */
	public double totalScore;
	/**
	 * ƽ���ɼ�
	 */
	public double avgScore;
}
