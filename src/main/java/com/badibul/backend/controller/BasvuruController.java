package com.badibul.backend.controller;

import com.badibul.backend.entity.Basvuru;
import com.badibul.backend.request.BasvuruCreateRequest;
import com.badibul.backend.request.UpdateBasvuruRequest;
import com.badibul.backend.response.BasvuruResponse;
import com.badibul.backend.service.BasvuruService;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/basvurular")
public class BasvuruController {

    private final BasvuruService basvuruService;

    public BasvuruController(BasvuruService basvuruService) {
        this.basvuruService = basvuruService;
    }
    @GetMapping("/{basvuruId}")
    public Basvuru getBasvuruById(@PathVariable Long basvuruId){

        return  basvuruService.getOneBasvuru(basvuruId);
    }
    @GetMapping
    public List<BasvuruResponse> getAllBasvurular(@RequestParam Optional<Long> userId, @RequestParam Optional <Long> eventId){

        return  basvuruService.getBasvuruByUserOrEventId(userId,eventId);
    }
    @PostMapping
    public Basvuru createOneBasvuru(@RequestBody BasvuruCreateRequest basvuruCreateRequest){

        return  basvuruService.createOneBasvuru(basvuruCreateRequest);
    }
    @DeleteMapping("/{basvuruId}")
    public void deleteOneBasvuru(@PathVariable Long basvuruId){

        basvuruService.deleteOneBasvuruById(basvuruId);
    }

    @PutMapping("/{basvuruId}")
    public Basvuru updateOneBasvuru(@PathVariable Long basvuruId,@RequestBody UpdateBasvuruRequest updateBasvuruRequest){

        return  basvuruService.updateBasvuru(basvuruId,updateBasvuruRequest);
    }

}
