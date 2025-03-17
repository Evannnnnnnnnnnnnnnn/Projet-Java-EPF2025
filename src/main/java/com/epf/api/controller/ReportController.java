package com.epf.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;

inport java.util.List;

@ResetController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    private final ReportDtoMapper dtoMapper;

    // pour plus tard : return new ResponseEntity<>(dtoMapper.mapModelToDto(reportService.getReportById(id)), HttpStatus.OK); 
}
