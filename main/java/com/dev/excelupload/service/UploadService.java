package dev.mj.excelupload.service;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadService {

	public void upload(MultipartFile file) throws Exception{
		Path tempDir = Files.createTempDirectory("");
		
		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
		
		Workbook workbook = WorkbookFactory.create(tempFile);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		Stream<Row> rowStream= StreamSupport.stream(sheet.spliterator(),false);
		rowStream.forEach(row->{
			//given a row, get a cellStream from it
			Stream<Cell> cellStream = StreamSupport.stream(row.spliterator(),false);
			List <String> cellVals = cellStream.map(cell -> {
				String cellVal = cell.getStringCellValue();
				return cellVal;
			})
			.collect(Collectors.toList());
			
			System.out.println(cellVals);
		});
	}

}
