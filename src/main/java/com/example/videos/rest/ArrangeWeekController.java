package com.example.videos.rest;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.service.WeekArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/arrangements")
public class ArrangeWeekController {

    @Autowired
    private WeekArrangementService weekArrangementService;

    @PostMapping(value = "/week")
    public ResponseEntity<?> postWeekArrangement(@RequestBody WeekArrangementDto weekArrangementDto) {
        weekArrangementService.save(weekArrangementDto);
        return ResponseEntity.ok(weekArrangementDto);
    }

}
