package com.warehouse.clustereddata.dto;

import com.warehouse.clustereddata.model.CurrencyCode;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DealDto {

    @NotBlank
    private String uniqueDealId;
    @NotBlank
    private String fromCurrency;
    @NotBlank
    private String toCurrency;
    @NotNull
    @Min(1)
    private Double amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
}
