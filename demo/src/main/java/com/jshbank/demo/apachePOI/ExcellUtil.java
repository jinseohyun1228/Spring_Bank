package com.jshbank.demo.apachePOI;

import io.micrometer.common.lang.NonNull;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.List;

public class ExcellUtil {
  public static void excelDownload(HttpServletResponse response, List<?> list, @NonNull String fileName) throws Exception{
    Workbook wb = new XSSFWorkbook();
    Sheet sheet = wb.createSheet(fileName);

    Row row = null;
    Cell cell = null;
    int rowNum = 0;
    int columnNum = 0;

    //제목 스타일 지정
    CellStyle style1 = wb.createCellStyle();
    style1.setAlignment(HorizontalAlignment.CENTER);                    //정렬 방식
    style1.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());  //배경 색상
    style1.setFillPattern(FillPatternType.BRICKS);                      //배경 패턴 설정
    style1.setBorderRight(BorderStyle.THIN);                            //테두리 선의 스타일 지정 (오른쪽,왼쪽,위,아래)
    style1.setBorderLeft(BorderStyle.THIN);
    style1.setBorderTop(BorderStyle.THIN);
    style1.setBorderBottom(BorderStyle.THIN);


    //vo의 제목 셋팅
    row = sheet.createRow(rowNum++);
    for(Field field : list.get(0).getClass().getDeclaredFields()){
      field.setAccessible(true);                //필드 접근 권한 설정
      cell = row.createCell(columnNum);         //현재 행의 columnNum번째 셀을 생성한다.
      cell.setCellStyle(style1);                //셀의 스타일을 적용한다.
      cell.setCellValue(field.getName());       //셀의 값을 설정한다!

      columnNum += 1;                           //다음 셀로 이동
    }

    CellStyle style2 = wb.createCellStyle();
    style2.setAlignment(HorizontalAlignment.CENTER);
    style2.setBorderRight(BorderStyle.THIN);
    style2.setBorderLeft(BorderStyle.THIN);
    style2.setBorderTop(BorderStyle.THIN);
    style2.setBorderBottom(BorderStyle.THIN);

    // vo의 리스트 셋팅
    for (int i=0; i<list.size(); i++) {               //리스트의 크기만큼!
      columnNum = 0;                                  //열 번호를 다시 초기화
      row = sheet.createRow(rowNum++);                //rowNum번째 행 만들기

      //통째로 안넣는 이유가 지금 내가 가진 객체가 리스트<객체>이런식으로 되어있음.
      // 따라서 리스트의 객체의 속성을 또 하나하나 가져오는 코드가 필요한 것!
      for(Field field : list.get(i).getClass().getDeclaredFields()){  //리스트를 가져옵시다!
        field.setAccessible(true);                    //필드 접근권환 활성화 시켜주고
        Object value = field.get(list.get(i));        //리스트의 값을 가져와주고

        cell = row.createCell(columnNum);             //셀을 만들어줍시다
        cell.setCellStyle(style2);                    //셀의 스타일을 넣어줍시다
        if (value != null) {
          cell.setCellValue(value.toString());        //셀이 int형인 경우도 있어서 안전하게 toString메서드 사용~
        } else {                                      //셀이 없는 경우에
          cell.setCellValue("");
        }
        columnNum += 1;                               //다음 셀로 이동~!!
      }
    }

    // 컨텐츠 타입과 파일명 지정
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    // 정규식 사용하여 파일명에 .@$^공백이 있을경우 _로 대체
    fileName = fileName.replaceAll("[.@$^\\s]", "_");
    // 헤더에 한글 셋팅
    fileName = URLEncoder.encode(fileName, "UTF-8");
    response.setHeader("Content-Disposition", "attachment;filename="+fileName+".xlsx");

    // Excel File Output
    wb.write(response.getOutputStream());
    wb.close();
  }
}
