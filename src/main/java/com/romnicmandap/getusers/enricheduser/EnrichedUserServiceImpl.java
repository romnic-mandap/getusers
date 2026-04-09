package com.romnicmandap.getusers.enricheduser;

import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserCreationDTO;
import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EnrichedUserServiceImpl implements EnrichedUserService {

    private EnrichedUserRepository enrichedUserRepository;

    @Autowired
    public void setEnrichedUserRepository(EnrichedUserRepository enrichedUserRepository){
        this.enrichedUserRepository = enrichedUserRepository;
    }

    @Override
    public Long createEnrichedUser(@Valid EnrichedUserCreationDTO enrichedUserCreationDTO) {
        EnrichedUser enrichedUser = new EnrichedUser();
        enrichedUser.setName(enrichedUserCreationDTO.name());
        enrichedUser.setEmail(enrichedUserCreationDTO.email());
        enrichedUser.setDepartment(enrichedUserCreationDTO.department());
        enrichedUser.setLastUpdated(LocalDateTime.now());
        return enrichedUserRepository.save(enrichedUser).getId();
    }

    @Override
    public List<EnrichedUserDTO> getAllEnrichedUsers() {
        return enrichedUserRepository
                .findAll()
                .stream()
                .map(this::convertEnrichedUserToEnrichedUserDTO)
                .toList();
    }

    private EnrichedUserDTO convertEnrichedUserToEnrichedUserDTO(EnrichedUser enrichedUser){
        return new EnrichedUserDTO(
                enrichedUser.getId(),
                enrichedUser.getName(),
                enrichedUser.getEmail(),
                enrichedUser.getDepartment(),
                enrichedUser.getLastUpdated()
        );
    }



}
