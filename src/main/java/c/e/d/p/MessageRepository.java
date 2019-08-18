package c.e.d.p;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    Message findDistinctByMessage(String message);

}
