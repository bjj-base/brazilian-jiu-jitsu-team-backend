package com.example.videos.rest;

import com.example.videos.dto.WeekArrangementDto;
import com.example.videos.model.video.Video;
import com.example.videos.model.weekArrangement.WeekArrangement;
import com.example.videos.service.TagService;
import com.example.videos.service.VideoService;
import com.example.videos.service.WeekArrangementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/arrangements")
public  class ArrangeWeekController <T extends Video>{

    @Autowired
    private WeekArrangementService weekArrangementService;

    @Autowired
    private TagService tagService;

    @Autowired
    private VideoService videoService;

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
    public ResponseEntity<?> getWeekArrangments(@PathVariable Long id, @RequestParam(required = false) String view) {

        WeekArrangementDto dto = weekArrangementService.findOneByIdToDto(id, View.valueOf(view));
        if( dto == null ) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
        return ResponseEntity.ok(dto);
    }

    @PutMapping(value = "/week")
    public ResponseEntity<?> updateArrangemnt (@RequestBody WeekArrangementDto dto ) throws InvocationTargetException, IllegalAccessException {
        Optional<WeekArrangement> weekArrangement = weekArrangementService.findOneById(dto.getId());

        if ( weekArrangement.isPresent()) {


            return ResponseEntity.ok(weekArrangementService.save(dto));
        }
//        else if ( video.isPresent() && video.get().getSource().equals("BRASA_HELLAS")) {
//            BeanUtils.copyProperties(video.get(), dto);
//            return ResponseEntity.ok(videoService.saveBrasa((BrasaVideo) video.get()));
//        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }

}
