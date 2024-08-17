package edu.admafk.union.union_app.repository

import com.admafk.union.union_app.entity.SubstitutosHerois
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SubstitutosHeroisRepository : JpaRepository<SubstitutosHerois, Long>
