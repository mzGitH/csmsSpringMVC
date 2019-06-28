package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ��ȡExcel������
 * 
 * @author
 */
public class ReadExcelUtils {
	private Logger logger = LoggerFactory.getLogger(ReadExcelUtils.class);
	private Workbook wb;
	private Sheet sheet;
	private Row row;

	public ReadExcelUtils(String filepath) {
		if (filepath == null) {
			return;
		}
		String ext = filepath.substring(filepath.lastIndexOf("."));
		try {
			InputStream is = new FileInputStream(filepath);
			if (".xls".equals(ext)) {
				wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(ext)) {
				wb = new XSSFWorkbook(is);
			} else {
				wb = null;
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
	}

	/**
	 * ��ȡExcel����ͷ������
	 * 
	 * @param InputStream
	 * @return String ��ͷ���ݵ�����
	 * @author zengwendong
	 */
	public String[] readExcelTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook����Ϊ�գ�");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// ����������
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			// title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = row.getCell(i).getCellFormula();
		}
		return title;
	}

	/**
	 * ��ȡExcel��������
	 * 
	 * @param InputStream
	 * @return Map ������Ԫ���������ݵ�Map����
	 * @author zengwendong
	 */
	public List<Map<Integer, Object>> readExcelContent() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook����Ϊ�գ�");
		}
		// Map<Integer, Map<Integer, Object>> content = new HashMap<Integer,
		// Map<Integer, Object>>();
		List<Map<Integer, Object>> list = new ArrayList<Map<Integer, Object>>();
		sheet = wb.getSheetAt(0);
		// �õ�������
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
			while (j < colNum) {
				Object obj = getCellFormatValue(row.getCell(j));
				cellValue.put(j, obj);
				j++;
			}
			// content.put(i, cellValue);
			list.add(cellValue);
		}
		// for (Map<Integer, Object> map : list) {
		// for (Map.Entry<Integer, Object> m : map.entrySet()) {
		// System.out.print(m.getKey() + "    ");
		// System.out.println(m.getValue());
		//
		// }
		// }
		return list;
	}

	/**
	 * 
	 * ����Cell������������
	 * 
	 * @param cell
	 * @return
	 * @author zengwendong
	 */
	private Object getCellFormatValue(Cell cell) {
		Object cellvalue = "";
		if (cell != null) {
			// �жϵ�ǰCell��Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// �����ǰCell��TypeΪNUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				if (DateUtil.isCellDateFormatted(cell)) {
					// �����Date������ת��ΪData��ʽ
					// data��ʽ�Ǵ�ʱ����ģ�2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data��ʽ�ǲ�����ʱ����ģ�2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// ����Ǵ�����

					// ȡ�õ�ǰCell����ֵ
					cellvalue = String.valueOf(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// �����ǰCell��TypeΪSTRING
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// Ĭ�ϵ�Cellֵ
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	// public static void main(String[] args) {
	//
	// File directory = new File("");// �趨Ϊ��ǰ�ļ���
	//
	// try {
	// System.out.println(directory.getCanonicalPath());
	// } catch (IOException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }// ��ȡ��׼��·��
	// System.out.println(directory.getAbsolutePath());// ��ȡ����·��
	//
	// try {
	//
	// String filepath = "LayUiLearn\\WEB-INF\\upload\\666.xlsx";
	// ReadExcelUtils excelReader = new ReadExcelUtils(filepath);
	// // �Զ�ȡExcel���������
	// // String[] title = excelReader.readExcelTitle();
	// // System.out.println("���Excel���ı���:");
	// // for (String s : title) {
	// // System.out.print(s + " ");
	// // }
	//
	// // �Զ�ȡExcel������ݲ���
	// List<Map<Integer, Object>> list = excelReader.readExcelContent();
	// List<TCollege> collegelist = new ArrayList<TCollege>();
	// System.out.println("���Excel��������:");
	// for (Map<Integer, Object> map : list) {
	// TCollege college = new TCollege();
	// for (Map.Entry<Integer, Object> m : map.entrySet()) {
	// switch (m.getKey()) {
	// case 0:
	// DecimalFormat df1 = new DecimalFormat("0");
	//
	// college.setCollegeid(Integer.parseInt(df1.format(Double
	// .parseDouble((String) m.getValue()))));
	// break;
	// case 1:
	// college.setCollegename(m.getValue().toString());
	// break;
	// default:
	// break;
	// }
	// }
	// collegelist.add(college);
	//
	// }
	// for (TCollege tCollege : collegelist) {
	// System.out.println(tCollege.getCollegeid() + ":"
	// + tCollege.getCollegename());
	// }
	// // for (int i = 1; i <= map.size(); i++) {
	// // System.out.println(map.get(i));
	// // }
	// } catch (FileNotFoundException e) {
	// System.out.println("δ�ҵ�ָ��·�����ļ�!");
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
