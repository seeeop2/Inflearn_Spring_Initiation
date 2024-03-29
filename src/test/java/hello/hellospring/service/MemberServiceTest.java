package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Service 클래스에서 command + shift + T : 해당 클래스의 Test 파일 생성
*/

//아래의 테스트는 '단위 테스트'이다.
//스프링 컨테이너에 올리지 않고 테스트하는 것을 '단위 테스트'라고 할 수 있다.
//순수한 '단위 테스트'가 '통합 테스트'에 비교해서 훨씬 좋은 테스트일 확률이 높다.

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;


    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

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

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 존재하는 회원입니.");

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