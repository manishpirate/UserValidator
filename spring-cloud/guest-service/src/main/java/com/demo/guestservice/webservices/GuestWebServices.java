package com.demo.guestservice.webservices;

import com.demo.guestservice.db.entity.Guest;
import com.demo.guestservice.db.repository.GuestRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
@Tag(name="GuestService", description = "The guest API")
public class GuestWebServices {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestWebServices(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    @Operation(summary = "Find all Guests")
    @ApiResponses(value = { @ApiResponse (responseCode = "200", description = "OK")})
    public Iterable<Guest> getAllGuest(){
        return guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable long id){
        return guestRepository.findById(id).get();
    }

}
