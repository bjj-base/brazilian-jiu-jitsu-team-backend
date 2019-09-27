package com.example.videos.rest;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.video.WeekArrangement;
import com.example.videos.service.WeekArrangementService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value = "/week")
    public ResponseEntity<?> getWeekArrangements() {
        return ResponseEntity.ok(weekArrangementService.findAll());
    }

    @GetMapping(value = "/week/{id}")
    public ResponseEntity<?> getWeekArrangments(@PathVariable Long id) {
        WeekArrangementDto dto = weekArrangementService.findOneById(id);
        if( dto == null ) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
        return ResponseEntity.ok(dto);
    }

}
