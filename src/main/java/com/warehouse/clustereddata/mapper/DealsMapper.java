package com.warehouse.clustereddata.mapper;

import com.warehouse.clustereddata.dto.DealDto;
import com.warehouse.clustereddata.model.Deal;

public class DealsMapper {

    public static DealDto mapToDealsDto(Deal deal, DealDto dealDto) {
        dealDto.setUniqueDealId(deal.getUniqueDealId());
        dealDto.setFromCurrency(deal.getFromCurrencyCode());
        dealDto.setToCurrency(deal.getToCurrencyCode());
        dealDto.setCreatedAt(deal.getCreatedAt());
        dealDto.setAmount(deal.getAmount());
        return dealDto;
    }

    public static Deal mapToDeals(DealDto dealDto, Deal deal) {
        deal.setUniqueDealId(dealDto.getUniqueDealId());
        deal.setFromCurrencyCode(dealDto.getFromCurrency());
        deal.setToCurrencyCode(dealDto.getToCurrency());
        deal.setCreatedAt(dealDto.getCreatedAt());
        deal.setAmount(dealDto.getAmount());
        return deal;
    }
}
