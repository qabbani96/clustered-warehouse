package com.warehouse.clustereddata.service.impl;

import com.warehouse.clustereddata.dto.DealDto;
import com.warehouse.clustereddata.exception.DealAlreadyExistsException;
import com.warehouse.clustereddata.exception.ResourceNotFoundException;
import com.warehouse.clustereddata.mapper.DealsMapper;
import com.warehouse.clustereddata.model.CurrencyCode;
import com.warehouse.clustereddata.model.Deal;
import com.warehouse.clustereddata.repository.DealsRepository;
import com.warehouse.clustereddata.service.IDealService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class DealServiceImpl implements IDealService {

    private DealsRepository dealsRepository;

    @Override
    public void saveValidDeals(@Valid DealDto dealDto) {

        dealDto.setCreatedAt(LocalDateTime.now());
        Deal deal = DealsMapper.mapToDeals(dealDto, new Deal());
        if(isCurrencyValid(dealDto.getToCurrency()))
            throw new ResourceNotFoundException("to currency", dealDto.getToCurrency(), dealDto.getUniqueDealId() );
        if(isCurrencyValid(dealDto.getFromCurrency()))
            throw new ResourceNotFoundException("from currency", dealDto.getToCurrency(), dealDto.getUniqueDealId() );

        Optional<Deal> dealOptional = dealsRepository.findByUniqueDealId(dealDto.getUniqueDealId());
        if(dealOptional.isPresent())
            throw new DealAlreadyExistsException("Deal already registered with given uniqueDealId" + dealDto.getUniqueDealId());

        dealsRepository.save(deal);
        log.info("Deal With uniqueDealId :" + deal.getUniqueDealId() + "saved successfully");
    }

    @Override
    public List<DealDto> allDeals() {
        List<Deal> dealList = dealsRepository.findAll();
        List<DealDto> dealDtos = dealList.stream()
                .map(deal -> DealsMapper.mapToDealsDto(deal, new DealDto()))
                .collect(Collectors.toList());
        log.info("Total deals return {} ",dealDtos.size());
        return dealDtos;
    }


    private boolean isCurrencyValid(String code){
        log.info(String.format("%s code ",code));
        return CurrencyCode.valueOf(code).name().isEmpty();
    }
}
