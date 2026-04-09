package com.romnicmandap.getusers.enricheduser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrichedUserRepository extends JpaRepository<EnrichedUser, Long> {


}
