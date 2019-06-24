package model;

/**
 * 存储用于layui table加载的json数据格式
 * @author Administrator
 *
 */
public class ReturnData {
	/**
	 * 成功
	 */
	public static int SUCCESS = 0;
	/**
	 * 失败
	 */
	public static int ERROR = 1;
	/**
	 * 加载状态，成功（SUCCESS），失败（ERROR）
	 */
	public int code;
	/**
	 * 提示信息
	 */
	public String msg;
	/**
	 * 数据记录数
	 */
	public int count;
	/**
	 * 数据的json字符串
	 */
	public Object data;
	/**
	 * 数据的json字符串
	 */
	public Object data1;
	/**
	 * 总成绩
	 */
	public double totalScore;
	/**
	 * 平均成绩
	 */
	public double avgScore;
}
