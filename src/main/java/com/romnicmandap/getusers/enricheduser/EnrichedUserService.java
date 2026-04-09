package com.romnicmandap.getusers.enricheduser;

import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserCreationDTO;
import com.romnicmandap.getusers.enricheduser.dto.EnrichedUserDTO;

import java.util.List;

public interface EnrichedUserService {

    Long createEnrichedUser(EnrichedUserCreationDTO enrichedUserCreationDTO);

    List<EnrichedUserDTO> getAllEnrichedUsers();


}
