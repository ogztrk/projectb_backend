package com.badibul.backend.service;

import com.badibul.backend.entity.Basvuru;
import com.badibul.backend.repository.BasvuruRepository;
import com.badibul.backend.request.BasvuruCreateRequest;
import com.badibul.backend.request.UpdateBasvuruRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BasvuruService {

    private final BasvuruRepository basvuruRepository;
    private final EventService eventService;
    private final UserService userService;

    public BasvuruService(BasvuruRepository basvuruRepository, EventService eventService, UserService userService) {
        this.basvuruRepository = basvuruRepository;
        this.eventService = eventService;

        this.userService = userService;
    }


    public Basvuru getOneBasvuru(Long basvuruId) {
        return basvuruRepository.findById(basvuruId).orElseThrow(null);
    }

    public List<Basvuru> getBasvuruByUserOrEventId(Optional<Long> userId, Optional<Long> eventId) {

        if (userId.isPresent() && eventId.isPresent()) {
            return basvuruRepository.findByUserIdAndEventId(userId.get(), eventId.get());
        } else if (userId.isPresent()) {
            return basvuruRepository.findByUserId(eventId.get());
        } else if (eventId.isPresent()) {
            return basvuruRepository.findByEventId(eventId.get());
        }
        return basvuruRepository.findAll();
    }

    public Basvuru createOneBasvuru(BasvuruCreateRequest basvuruCreateRequest) {
        if (userService.getOneUser(basvuruCreateRequest.getUserId()) != null && eventService.GetOneEvent(basvuruCreateRequest.getEventId()) != null) {
            Basvuru newBasvuru = new Basvuru();
            newBasvuru.setUser((userService.getOneUser(basvuruCreateRequest.getUserId())));
            newBasvuru.setEvent(eventService.GetOneEvent(basvuruCreateRequest.getEventId()));
            newBasvuru.setId(basvuruCreateRequest.getId());
            newBasvuru.setOnay(basvuruCreateRequest.getOnay());
            newBasvuru.setBasvuruTarihi(basvuruCreateRequest.getBasvuruTarihi());
            return basvuruRepository.save(newBasvuru);
        }
        return null;
    }

    public void deleteOneBasvuruById(Long basvuruId) {

        basvuruRepository.deleteById(basvuruId);
    }

    public Basvuru updateBasvuru(Long basvuruId, UpdateBasvuruRequest updateBasvuruRequest) {
        Optional<Basvuru> basvuru=basvuruRepository.findById(basvuruId);
        if (basvuru.isPresent()){
            Basvuru updatedBasvuru= basvuru.get();
            updatedBasvuru.setOnay(updateBasvuruRequest.getOnay());
            updatedBasvuru.setBasvuruTarihi(updateBasvuruRequest.getBasvuruTarihi());
            return basvuruRepository.save(updatedBasvuru);
        }
        return null;
    }
}