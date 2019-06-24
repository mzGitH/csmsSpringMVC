package common.properties;

import java.util.List;

/**
 * 操作日志中的类型数据
 * @author Administrator
 *
 */
public class OperType {
	
	/**
	 * 添加数据操作类型
	 */
	public static final String ADD = "add";
	/**
	 * 修改数据操作类型
	 */
	public static final String MODIFY = "modify";
	/**
	 * 修改数据操作类型
	 */
	public static final String DELETE = "delete";
	/**
	 * 查询数据操作类型
	 */
	public static final String QUERY= "query";
	
	public static final String[] OPERTYPES = {
		"add","modify","delete","query"};
	
}
