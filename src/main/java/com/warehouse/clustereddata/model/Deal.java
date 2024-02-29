package com.warehouse.clustereddata.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document("deals")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueDealId;
    @NotBlank
    private String fromCurrencyCode;
    @NotBlank
    private String toCurrencyCode;
    @NotNull
    private Double amount;
    private LocalDateTime createdAt;
}
