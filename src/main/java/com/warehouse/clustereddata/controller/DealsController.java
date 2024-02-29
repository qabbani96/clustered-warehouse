package com.warehouse.clustereddata.controller;

import com.warehouse.clustereddata.constants.DealsConstants;
import com.warehouse.clustereddata.dto.DealDto;
import com.warehouse.clustereddata.dto.ResponseDto;
import com.warehouse.clustereddata.service.IDealService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/deal" )
public class DealsController {

    @Autowired
    private IDealService iDealService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createDeal( @RequestBody @Valid DealDto dealDto){
        iDealService.saveValidDeals(dealDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(DealsConstants.STATUS_201 , DealsConstants.MESSAGE_201));
    }

    @GetMapping()
    public ResponseEntity<List<DealDto>> allDeals(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(iDealService.allDeals());
    }
}
