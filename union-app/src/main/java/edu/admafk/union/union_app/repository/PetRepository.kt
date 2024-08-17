package edu.admafk.union.union_app.repository

import edu.admafk.union.union_app.entity.Pet
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : JpaRepository<edu.admafk.union.union_app.entity.Pet, Long>
