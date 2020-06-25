package PoiTest2.PoiTest2;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String path = "D:\\blackShin\\test.xls";
		// System.out.println(readXls(path));
		// test();
		readXls(path);
	}

	public static void readXls(String path) {
		String text = "";
		try {
			FileInputStream is = new FileInputStream(path);
			HSSFWorkbook excel = new HSSFWorkbook(is);
			// 获取第一个sheet
			HSSFSheet sheet0 = excel.getSheetAt(0);
			// 获取第二个sheet
			HSSFSheet sheet1 = excel.getSheetAt(1);

			List<Man> manList = new ArrayList<Man>();

			for (Iterator<?> rowIterator = sheet0.iterator(); rowIterator.hasNext();) {
				HSSFRow row = (HSSFRow) rowIterator.next();

				Man man = new Man();
				man.setName(row.getCell(0).toString());
				man.setPhone(row.getCell(1).toString());
				man.setCode(row.getCell(2).toString());
				man.setExt(row.getCell(3).toString());
				manList.add(man);

			}
			List<Man> man2List = new ArrayList<Man>();
			for (Iterator<?> rowIterator = sheet1.iterator(); rowIterator.hasNext();) {
				HSSFRow row = (HSSFRow) rowIterator.next();

				Man man = new Man();
				man.setName(row.getCell(0).toString());
				man.setPhone(row.getCell(1).toString());
				man.setCode(row.getCell(2).toString());
				man.setExt(row.getCell(3).toString());
				man2List.add(man);

			}

			for (int i = 0; i < manList.size(); i++) {
				for (int j = 0; j < man2List.size(); j++) {
					if (manList.get(i).equals(man2List.get(j))) {
						if ((!manList.get(i).getCode().equals(man2List.get(j).getCode())
								|| !(manList.get(i).getExt().equals(man2List.get(j).getExt())))) {
							System.err.println(manList.get(i).getName());
						}
					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// log.warn(e);
		}

	}

	public static void test() {

		Man man1 = new Man();
		man1.setName("123");
		man1.setPhone("999");
		man1.setCode("987");

		Man man2 = new Man();
		man2.setName("123");
		man2.setPhone("999");
		man2.setCode("456");

		System.out.println(man1.equals(man2));

	}

}
