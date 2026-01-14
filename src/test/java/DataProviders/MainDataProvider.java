package DataProviders;

import org.testng.annotations.*;
import utils.DataParsing;

import java.io.IOException;


public class MainDataProvider  {

    @DataProvider(name="resultPageCheck")
    Object[][] resultPageCheckData() throws Exception{
        Object[][] obj={
                {"30", "70", "120/30"}
        };
        return obj;
    }


    @DataProvider(name="dp")
    Object[][] testData() throws IOException {

        DataParsing parsing=new DataParsing();
        Object[][] data = parsing.parseExcel();
        return data;

    }

}
