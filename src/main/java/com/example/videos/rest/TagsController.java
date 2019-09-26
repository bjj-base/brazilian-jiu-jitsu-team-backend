package com.example.videos.rest;

import com.example.videos.model.tags.Tag;
import com.example.videos.service.TagService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Tag> videos = tagService.findAll();
        return ResponseEntity.ok(videos);
    }


    @PostMapping
    public ResponseEntity<?> postTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.save(tag));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVideo(@PathVariable Long id) {
        Optional<Tag> tag = tagService.findOneById(id);
        if ( tag.isPresent() ) {
            return ResponseEntity.ok().body(tag.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }

    @PutMapping
    public ResponseEntity<?> updateTag ( @RequestBody Tag dto ) throws InvocationTargetException, IllegalAccessException {
        Optional<Tag> tag = tagService.findOneById(dto.getId());

        if ( tag.isPresent() ) {
            BeanUtils.copyProperties(tag.get(), dto);
            return ResponseEntity.ok(tagService.save(tag.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }





}
