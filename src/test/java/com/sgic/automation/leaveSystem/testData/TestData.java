package com.sgic.automation.leaveSystem.testData;

import com.sgic.automation.leaveSystem.utils.ExcelDataConfig;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;

public class TestData extends ExcelDataConfig {
    private static final Logger LOGGER = Logger.getLogger(TestData.class);
    public TestData() {super
            ("src\\test\\resources\\ExcelSheet\\OrangeHrm.xlsx");

    }
    @DataProvider(name = "Login")
    public Object[][] Login() {

        int rows = getRowCount("AddRole");
        int col = getColumnCount("AddRole");

        LOGGER.info("row = "+ rows + " columns = "+ col);

        Object[][] data = new Object[rows][col];
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < col; j++) {
                data[i - 1][j] = getData("AddRole", i, j);
            }
        }
        return data;
    }
}
