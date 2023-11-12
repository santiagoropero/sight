package co.uninpahu.sight.admin.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@NoArgsConstructor
@Slf4j
@Service
public class TimeManagerService {
    private static final String ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String TIME_ZONE = "UTC";

    public String getInstantIsoFormat() {
        TimeZone timeZone = TimeZone.getTimeZone(TIME_ZONE);
        DateFormat dateFormat = new SimpleDateFormat(ISO_FORMAT);
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(new Date());
    }

    public Date getFormatDate(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if (date != null) {
                return dateFormat.parse(date);
            }
            log.error("La fecha es nula");
            return null;
        } catch (ParseException e) {
            log.error("Error parseando fecha, detalles: {} ", e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
