package dev.fileupload.excelupload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.fileupload.excelupload.model.FileColumns;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;


@Component
public class UploadUtil {
    public static String excelProcessor(File inputFile) {
        try (FileInputStream file = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheetAt(0); // Get the first sheet

            Map<String, List<FileColumns>> mapRows = new HashMap<>();

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                String rowKey = "Row" + row.getRowNum();
                FileColumns fileData = new FileColumns();

                List<FileColumns> fileDataList = new ArrayList<>();
                Map<String, String> column0Map = new HashMap<>();
                Map<String, String> column1Map = new HashMap<>();
                Map<String, String> column2Map = new HashMap<>();
                Map<String, String> column3Map = new HashMap<>();
                Map<String, String> column4Map = new HashMap<>();
                Map<String, String> column5Map = new HashMap<>();
                Map<String, String> column6Map = new HashMap<>();
                Map<String, String> column7Map = new HashMap<>();
                Map<String, String> column8Map = new HashMap<>();
                Map<String, String> column9Map = new HashMap<>();
                Map<String, String> column10Map = new HashMap<>();
                Map<String, String> column11Map = new HashMap<>();
                
                
                Cell column0 = row.getCell(0);
                if (column0 != null) {
                	System.out.println("NOT NULL-comn 1");
                    String RDW = column0.toString().substring(0, 3);
                    column0Map.put("RDW", RDW);
                    String PI = column0.toString().substring(4, 4);
                    column0Map.put("Prcess Ind", PI);
                  String TS = column0.toString();
                    TS = (TS.length() == 14) ? TS.substring(5,18): "" ;
                    column0Map.put("Time Stamp", TS);
                    String RSVED = column0.toString().substring(19, 19);
                    column0Map.put("Reserved", RSVED);
                    String IDNUM = column0.toString().substring(20,26);
                    column0Map.put("ID Number", IDNUM);
                    System.out.println(column0Map);
                }
                
              Cell column1 = row.getCell(1);
                if(column1 != null) {
                	System.out.println("NOT NULL-comn 2");
                	String CYClEID = column1.toString().substring(0,2);
                    column1Map.put("Cycle Identifier",CYClEID );
                    System.out.println(column1Map);
                }
               
            Cell column2 = row.getCell(2);
                if(column2 != null) {
                	System.out.println("NOT NULL-comn 3");
                	String PT = column2.toString().substring(0,1);
                    column2Map.put("Portfolio Type", PT); 
                	String AT = column2.toString().substring(1,3);
                    column2Map.put("Account Type", AT); 
                    String DO = column2.toString().substring(3,11);
                    column2Map.put("Date Opened", DO); 
                    String CL = column2.toString().substring(11,20);
                    column2Map.put("Credit Limit", CL); 
                    String OGLOAN = column2.toString().substring(20,29);
                    column2Map.put("Original Loan",OGLOAN);
                    String TERMDUR = column2.toString().substring(29,30);
                    column2Map.put("Term Duration",TERMDUR);
                    System.out.println(column2Map);
                }
               Cell column3 = row.getCell(3);
                if(column3 != null) {
                	System.out.println("NOT NULL-comn 4");
                	String TERMFREQ = column3.toString().substring(0,0);
                    column3Map.put("Term Frequency", TERMFREQ); 
                    String SCHEDAMNT = column3.toString().substring(1,9);
                    column3Map.put("Scheduled Monthly Payment Amount", SCHEDAMNT); 
                    String ACTPAYAM = column3.toString().substring(10,18);
                    column3Map.put("Actual Payment Amount", ACTPAYAM);
                    String PAYRAT = column3.toString().substring(19,20);
                    column3Map.put("Account Status", PAYRAT);
                    
                    String PAYRATE = column3.toString().substring(21,21);
                    column3Map.put("Payment Rating", PAYRATE);
                    String PAYHISTPROF = column3.toString().substring(22,45);
                    column3Map.put("Payment History Profile", PAYHISTPROF);
                    
                    String SPECCOM = column3.toString().substring(46,47);
                    column3Map.put("Special Comment", SPECCOM);
                    String COMPCONCODE = column3.toString().substring(48,49);
                    column3Map.put("Comp Condition Code", COMPCONCODE);
                    String CURRBALAN = column3.toString().substring(50,58);
                    column3Map.put("Current Balance", CURRBALAN);

                    String AMNTPASTDUE = column3.toString().substring(59,67);
                    column3Map.put("Amount Past Due", AMNTPASTDUE);
                    String OGCHRGEOFFAMT = column3.toString().substring(68,76);
                    column3Map.put("OG Charge-off Amount", OGCHRGEOFFAMT);
                    
                    String DATEACCINFO = column3.toString().substring(77,84);
                    column3Map.put("Date to Acc Info", DATEACCINFO); 
                    String FRCACOMP = column3.toString().substring(85,92);
                    column3Map.put("FRCA Compliance", FRCACOMP);
                    
                    String DATECLSD = column3.toString().substring(93,100);
                    column3Map.put("Date Closed", DATECLSD);
                    String DATELP = column3.toString().substring(101,108);
                    column3Map.put("Date Last Payment", DATELP);
                    System.out.println(column3Map);
                }

                Cell column4 = row.getCell(4);
                if(column4 != null) {
                	System.out.println("NOT NULL-comn 4");
                	//padding here
                	String SURNAME = column4.toString();
                	//SURNAME = SURNAME.substring(0,SURNAME.length());
                	//String SURNAME = column4.toString().substring(0,24);
                    column4Map.put("Interest Type Indicator", SURNAME);
                    System.out.println(column4Map);
                }
  
                column5Map.put("Sub Later", "");
                System.out.println(column5Map);
                
                Cell column6 = row.getCell(6);
                System.out.println("NOT NULL-comn 6");
                if(column6 != null) {
                	String FRSTNAME = column6.toString();
                    column6Map.put("First Name", FRSTNAME);
                    System.out.println(column6Map);
                }
                
                Cell column7 = row.getCell(7);
                if(column7 != null) {
                	System.out.println("NOT NULL-comn 7");
                	String MIDNAME = column7.toString();
                	MIDNAME = (MIDNAME.length() == 20) ? MIDNAME.substring(0,19): "" ;
                	column7Map.put("MIDNAME", "");
                	String GENCD = column7.toString();
                	GENCD = (GENCD.length() == 1) ? GENCD.substring(20,20): "";
                	column7Map.put("GENCD", "");
                	System.out.println(column7Map);
                	
                }
                Cell column8 = row.getCell(8);
                if(column8 != null) {
                	System.out.println("NOT NULL-comn 9");
                	String SSN = column8.toString().substring(0,8);
                    column8Map.put("Social Security Number", SSN);
                    String DOFBIRTH = column8.toString().substring(9,16);
                    column8Map.put("Date of Birth", DOFBIRTH);
                    String TELENUM = column8.toString().substring(17,26);
                    column8Map.put("Telephone Number", TELENUM);
                    String ECOACDE = column8.toString().substring(27,27);
                    column8Map.put("ECOA Code", ECOACDE);
                   
                    String CONSINFOIND = column8.toString();
                    CONSINFOIND = (CONSINFOIND.length() == 2) ? CONSINFOIND.substring(28,29): "";
                    System.out.println(column8Map);
                    //String CONSINFOIND = column8.toString().substring(28,29);
                    //column8Map.put("Consumer Information Indicator", CONSINFOIND);
                    ;
                }
                
                Cell column9 = row.getCell(9);
                if(column9 != null) {
                	System.out.println("NOT NULL-comn 10");
                	String CONCODE = column9.toString().substring(0,1);
                    column9Map.put("Country Code", CONCODE);
                   
                    String FLNEADDR = column9.toString();
                    FLNEADDR = (FLNEADDR.length() == 32) ? FLNEADDR.substring(2,33): FLNEADDR.substring(2,FLNEADDR.length());
                    
                    String SLNEADDR = column9.toString();
                    SLNEADDR = (SLNEADDR.length() == 32) ? SLNEADDR.substring(34,64): "";
                    System.out.println(column9Map);
                    
                    //column9Map.put("First Line Address", FLNEADDR);
                    //String SLNEADDR = column9.toString().substring(34,64);
                    //column9Map.put("Second Line Address", SLNEADDR);
                }
                
                Cell column10 = row.getCell(10);
                if(column10 != null) {
                	System.out.println("NOT NULL-comn 11");
                	String CITY = column10.toString();
                	CITY = (CITY.length() == 20) ? CITY.substring(0,19): CITY.substring(0,CITY.length());
                	column10Map.put("CITY", "");
                	//String CITY = column10.toString().substring(0,19);
                    //column10Map.put("City", CITY);
                	System.out.println(column10Map);
                }
                
                Cell column11 = row.getCell(11);
                if(column11 != null) {
                	System.out.println("NOT NULL-comn 12");
                	String STATE = column11.toString().substring(0,1);
                    column11Map.put("State", STATE);
                    
                    String ZIP = column11.toString();
                    ZIP = (ZIP.length() == 9) ? ZIP.substring(2,10): ZIP.substring(0,ZIP.length());
                    //String ZIP = column11.toString().substring(2,10);
                    //column8Map.put("ZIP Code", ZIP);
                    String ADDRIND = column11.toString();
                    ADDRIND = (ADDRIND.length() == 1) ? ADDRIND.substring(11,11): "";
                    
                    String RESCODE = column11.toString();
                    RESCODE = (RESCODE.length() == 1) ? RESCODE.substring(12,12): "";
                    System.out.println(column11Map);
                    //String ADDRIND = column11.toString().substring(11,11);
                    //column11Map.put("Address Indicator", ADDRIND);
                    //String RESCODE = column11.toString().substring(12,12);
                    //column11Map.put("Residence Code", RESCODE);
                }

                //Leave this alone - this will add the list and the maps
                fileDataList.add(fileData);
                mapRows.put(rowKey, fileDataList);
            }

            // Need to sort the maps; Otherwise result will give rows in unsorted order
            Map<String, List<FileColumns>> result = sortByKeys(mapRows);

            //Convert maps to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.writeValueAsString(result));
            return objectMapper.writeValueAsString(result);

        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Sort Rows Alphabetically using the Key
    public static <K extends Comparable, V> Map<K,V> sortByKeys(Map<K,V> map) {
        return new TreeMap<>(map);
    }



}
