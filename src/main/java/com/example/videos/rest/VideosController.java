package com.example.videos.rest;

import com.example.videos.dto.VideoDto;
import com.example.videos.model.video.BrasaVideo;
import com.example.videos.model.video.Source;
import com.example.videos.model.video.Video;
import com.example.videos.model.video.YoutubeVideo;
import com.example.videos.service.TagService;
import com.example.videos.service.VideoService;
import com.example.videos.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.beanutils.BeanUtils;

@RestController
@RequestMapping(value = "/api/videos")
public class VideosController {

    @Autowired
    private VideoService videoService;

    @Autowired
    private TagService tagService;

    /**
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Video> videos = videoService.findAll();
        List<VideoDto> dtos = videos
                .stream()
                .map(video -> {
                    VideoDto dto = new
                            VideoDto.DtoBuilder()
                            .withId(video.getId())
                            .withDescription(video.getDescription())
                            .withName(video.getName())
                            .withSource(video.getSource())
                            .withTags(video.getTags().stream().map(Tag::getId).collect(Collectors.toList()))
                            .build();
                    return dto;
                }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    /**
     *
     * @param source
     * @param video
     * @return
     */
    @PostMapping(value = "/external")
    public ResponseEntity<?> postExterrnal(@RequestParam Source source, @RequestBody YoutubeVideo video) {
        return ResponseEntity.ok(videoService.saveYoutube(video));
    }

    /**
     *
     * @param video
     * @return
     */
    @PostMapping
    public ResponseEntity<?> postBrasaVideo(@RequestBody BrasaVideo video) {
        return ResponseEntity.ok(videoService.saveBrasa(video));
    }

    /**
     *
     * @param id
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getVideo(@PathVariable Long id) throws InvocationTargetException, IllegalAccessException {
        Optional<Video> video = videoService.findOneById(id);

        if ( video.isPresent() ) {
            VideoDto dto = new VideoDto();
            BeanUtils.copyProperties(dto, video.get());
            dto.setTagIdList(
                    video.get().getTags()
                            .stream()
                            .map(Tag::getId)
                            .collect(Collectors.toList()));
            return ResponseEntity.ok().body(dto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }

    /**
     *
     * @param dto
     * @param <T>
     * @return
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @PutMapping
    public <T extends Video>  ResponseEntity<?> updateVideo ( @RequestBody VideoDto dto ) throws InvocationTargetException, IllegalAccessException {
        Optional<T> video = videoService.findOneById(dto.getId());

        if ( video.isPresent() && video.get().getSource().equals("YOUTUBE")) {
            List<Tag> tags = tagService.findAllById(dto.getTagIdList());
            BeanUtils.copyProperties(video.get(), dto);
            Map<Long, Tag> tagMap = tagService.findAllById(dto.getTagIdList())
                    .stream()
                    .collect(Collectors.toMap(Tag::getId, tag -> tag));

            video.get().setTags(dto.getTagIdList()
                    .stream()
                    .filter(Objects::nonNull)
                    .map(tagId ->{
                        Tag tag = tagMap.get(tagId);
                        return  tag;
                    }).collect(Collectors.toList())
            );
//
//            video.get().setTags(video.get()
//                    .getTags()
//                    .stream()
//                    .map(tag -> tagMap.get(tag.getId()))
//                    .collect(Collectors.toList()));

            return ResponseEntity.ok(videoService.saveYoutube((YoutubeVideo) video.get()));
        } else if ( video.isPresent() && video.get().getSource().equals("BRASA_HELLAS")) {
            BeanUtils.copyProperties(video.get(), dto);
            return ResponseEntity.ok(videoService.saveBrasa((BrasaVideo) video.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(HttpEntity.EMPTY);
    }





}
