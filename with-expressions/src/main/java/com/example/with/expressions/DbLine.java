package com.example.with.expressions;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@AllArgsConstructor
public class DbLine{
    private static final String dateFormat = "yyyy-MM-dd";
        public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
    private static final SimpleDateFormat formatter1 = new SimpleDateFormat(dateFormat);



        private int siteId;
        private long interactionId;
        private String contactGMTStartTimeAsString;
        private long archiveId;
        private String setNumber;
        private Integer iEsmDeviceID; // Nullable value in the database
        private String vcArchiveUniqueId;

        private LocalDate convertStringToLocalDateTime(String theDate) {
            return LocalDate.parse(theDate, formatter);
        }

        @SneakyThrows
        public Date contactGMTStartTimeAsDate() {
            return formatter1.parse(contactGMTStartTimeAsString);
        }

        public LocalDate getFirstDayInMonth() {
            return LocalDate.parse(contactGMTStartTimeAsString, formatter).withDayOfMonth(1);
        }

        public LocalDate getContactGMTStartTime() {
            return LocalDate.parse(contactGMTStartTimeAsString, formatter);
        }

        @Override
        public String toString() {
            return "DbLine [archiveId=" + archiveId + ", interactionId=" + interactionId + ", contactGMTStartTimeAsString=" + contactGMTStartTimeAsString + "]";
        }
}
