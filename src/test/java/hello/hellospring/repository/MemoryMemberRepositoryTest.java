package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  //테스트메소드가 끝날 때 마다 콜백되는 메소드. 테스트마다 의존이 되지 않게 설계 되어야 한다.
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();  /*
                                                        반환타입이 optional 이라서 get 메소드를 사용한다.
                                                        get 메소드로 꺼내는 것이 좋은 방법은 아니다.
                                                        그러나, 테스트 코드에서는 괜찮다.
                                                    */
        System.out.println("result = " + (result == member));   //계속 이렇게 문자로 확인하는 것 무리가 있다. 그래서 아래의 메소드 이용

        //방법1.
//        Assertions.assertEquals(  member   ,        result);    //같다면, 아무 이상없이 테스트 코드 실행
                                //기대하는 것        실제 나온 것
//        Assertions.assertEquals(member,null);             //이렇게 다르다면, 테스트 코드 에러 발생

        //방법2. -----> 강사님 생각에는 조금 더 편한 방식.. (assertj)
        Assertions.assertThat(member).isEqualTo(result);    //두 객체가 같아서 이상 없이 코드 실행
//        Assertions.assertThat(member).isEqualTo(null);//이렇게 다르다면, 테스트 코드 에러 발생
                                                                //실무에서는 이렇게 다음 코드로 못 넘어가게 에러를 발생시켜 테스트를 진행
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  //변수에 shift+F6 누르면 여러 곳에 흩어져있는 변수 한번에 수정 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //option + command + v : 자동 객체 선언

        Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(2);
//        Assertions.assertThat(result.size()).isEqualTo(3); // 일부러 에러 발생시키는 부분


    }


}
