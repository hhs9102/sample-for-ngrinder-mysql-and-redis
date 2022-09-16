package com.example.sampleforngrindermysql

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import javax.persistence.Entity
import javax.persistence.Id

@Repository
interface MysqlRepository : CrudRepository<User, Int> {
    fun findUserById(id: Int): User
}

@Entity
data class User(@Id val id: Int, val name: String)