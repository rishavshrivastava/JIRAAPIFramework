package jira;

import utility.PathVariables;
import utility.Util;

public class Demo implements PathVariables{

	public static void main(String[] args) throws Exception {
		Util.putData(excelPath, sheetname, 3, 1, "commentid");
		
	}
}