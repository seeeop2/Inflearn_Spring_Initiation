package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
Service 클래스에서 command + shift + T : 해당 클래스의 Test 파일 생성
*/

//아래의 테스트는 '스프링 통합 테스트'이다.
//통합 테스트는 스프링 컨테이너 혹은 DB를 연동해서 하는 테스트이다.


@SpringBootTest
@Transactional  //테스트 하고 커밋을 하는 것이 아닌 롤백을 한다. 다음 테스트에 영향을 주지 않기 위함.
class MemberServiceIntegrationTest {

    @Autowired          //원래는 생성자 주입을 했겠지만, 테스트 코드는 제일 편하게 autowired 사용.
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {         //test 코드 같은 경우, 한글로 메소드 이름 지정해도 괜찮다.
                            //빌드될 때 test파일이 만들어지는 것도 아니고, 국내에서만 활동할 시 무관하다.

        //given '아~ 이 데이터를 기반으로 하구나'

        Member member = new Member();
        member.setName("hello");
        
        //when  '아~ 이것을 검증하구나'

        Long saveId = memberService.join(member);

        //then

        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName()); /*
                                                                                    동일한 것이 있으면 테스트 통과,
                                                                                    동일한 것이 없으면 에러 발생
                                                                                */
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 존재하는 회원입니다.");

        //when

        //then


    }


    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}