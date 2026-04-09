package com.romnicmandap.getusers.enricheduser;

import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserCreationDTO;
import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserCreationResponseDTO;
import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EnrichedUserController {

    private EnrichedUserService enrichedUserService;

    @Autowired
    public void setEnrichedUserService(EnrichedUserService enrichedUserService){
        this.enrichedUserService = enrichedUserService;
    }

    @GetMapping(value="/enriched-users", produces={"application/json"})
    public ResponseEntity<List<EnrichedUserDTO>> getAllEnrichedUsers(){
        return new ResponseEntity<>(
                enrichedUserService.getAllEnrichedUsers(),
                HttpStatus.OK
        );
    }

    @PostMapping(value="/enriched-users", produces={"application/json"}, consumes={"application/json"})
    public ResponseEntity<EnrichedUserCreationResponseDTO> addEnrichedUser(
            @RequestBody @Valid EnrichedUserCreationDTO enrichedUserCreationDTO
            ){
        return new ResponseEntity<>(
                new EnrichedUserCreationResponseDTO(
                        enrichedUserService.createEnrichedUser(enrichedUserCreationDTO)
                ),
                HttpStatus.CREATED
        );
    }


}
