package lucas.chaves.bootdemo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.time.Instant
import javax.persistence.*


interface TodoRepository : JpaRepository<Todo, Long>

@RestController
@RequestMapping(value = "/todo")
@EnableWebMvc
class TodoResource(val todoRepo: TodoRepository) {

    @GetMapping(value = "/")
    fun getAll() {
        todoRepo.findAll()
    }
}

@Entity
class Todo(@Id @GeneratedValue(strategy = GenerationType.AUTO)
           val Id: Long = 0, var text: String = "", var done: Boolean = false, val createdAt: Instant = Instant.now())