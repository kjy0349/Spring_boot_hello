package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member result;
        result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member result = repository.findByName(member.getName()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findAll() {
        Member member = new Member();
        member.setName("spring");
        repository.save(member);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        assertThat(repository.findAll().size()).isEqualTo(2);
    }
}
