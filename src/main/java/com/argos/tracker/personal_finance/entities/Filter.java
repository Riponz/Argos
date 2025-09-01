package com.argos.tracker.personal_finance.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    private String yearMonth;
    private LocalDateTime start;
    private LocalDateTime end;
    private Integer categoryId;
    private String method;
}