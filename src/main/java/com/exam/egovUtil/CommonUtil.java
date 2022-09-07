package com.exam.egovUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
    private final Log log = LogFactory.getLog(CommonUtil.class);

    // String(yyyymmdd) -> LocalDate 변환
    public static LocalDate StringToLocaldate(String date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);//yyyyMMdd
        try {
            LocalDate localDate = LocalDate.parse(date, formatter);
            return localDate;
        }catch(DateTimeParseException e){
            System.out.println("날짜형식("+format+")이 맞지 않습니다. \n" + e);
        }
        return null;
    }

    // String(yyyymmdd) -> LocalDateTime 변환
    public static LocalDateTime StringToLocalDateTime(String date, String type, String format){
        // type = start : 00:00시
        // type = end : 12:31시
        LocalDate ymd = StringToLocaldate(date,format);

        LocalDateTime sdt =LocalDateTime.of(ymd, LocalTime.of(0, 0)); // 2019-01-01T00:00
        LocalDateTime edt = LocalDateTime.of(ymd, LocalTime.of(23, 59)); // 2019-12-31T23:59

        if(type.equals("end"))
            return edt;
        else
            return sdt;

    }

    // LocaldateTime -> String(yyyyMMdd)
    public static String LocalDateTimeToString(LocalDateTime date, String format){
        String rtl  = date.format(DateTimeFormatter.ofPattern(format));
        return rtl;
    }

    // LocalDateTime -> ZonedDateTime
    public static ZonedDateTime LocalDateTimeToZonedDateTime(LocalDateTime date){
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, ZoneId.of("Asia/Seoul"));
        return zonedDateTime;
    }

    // String -> ZonedDateTime
    public static ZonedDateTime StringToZonedDateTime(String date, String type, String format){
        LocalDateTime ldt = StringToLocalDateTime(date, type, format);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        return zonedDateTime;
    }

    // ZonedDateTime -> String(yyyyMMdd)
    public static String ZonedDateTimeToString(ZonedDateTime date, String format){
        String rtl  = date.format(DateTimeFormatter.ofPattern(format));
        return rtl;
    }

    // 입력된 기간 사이의 날짜목록을 반환
    public static List<String> DateRangeList(String sd, String ed, String format){
        List rtl = new ArrayList();
        //sd = "20190501";
        //ed = "20190531";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate lsd = StringToLocaldate(sd, format);
        LocalDate led = StringToLocaldate(ed, format);

        for (LocalDate d = lsd; !d.isAfter(led); d = d.plusDays(1)) {
            rtl.add( d.format(formatter) );
            //System.out.println(d);
        }

        return rtl;
    }
}

