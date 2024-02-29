package com.warehouse.clustereddata.service;

import com.warehouse.clustereddata.dto.DealDto;
import com.warehouse.clustereddata.model.Deal;

import java.util.List;

public interface IDealService {

     void saveValidDeals(DealDto dealDto);
     List<DealDto> allDeals();

}
