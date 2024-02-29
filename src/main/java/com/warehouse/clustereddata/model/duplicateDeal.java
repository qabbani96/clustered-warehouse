package com.warehouse.clustereddata.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("duplicate_deals")
@Data
public class duplicateDeal {
    @Id
    private String id;
    @Indexed(unique = true)
    private String uniqueDealId;

}
