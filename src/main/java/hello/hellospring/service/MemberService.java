package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //1. 회원가입
    public Long join(Member member){
        
        //같은 이름이 있는 중복 회원 존재 X
/*원래는 이 방식인데, Optional도 보이고, 단순하지 못해서 선호하지 않음.
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
*/
        
/*
위 설명처럼 이렇게 단순하게 나오는 것을 선호.
그러나 이렇게 로직이 나오면, 메소드를 바깥으로 빼주는 것을 선호.
Ctrl + T > Extract Method
        memberRepository.findByName(member.getName())
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 존재하는 회원입니다.");
                        });
*/
        validateDuplicateMember(member); //Extract Method를 하니 매우 단순해졌다.

        memberRepository.save(member);
        return member.getId();

    }   //join 메소드 끝
                /*
                Service는 비즈니스에 가까운 메소드 이름을 작성해야한다.
                기획자나 다른 개발자가 "회원가입 로직이 이상하다"라고 하면 join메소드를 확인할 수 있어야 한다.
                그러나, Repository는 직관적 알 수 있도록 메소드 이름을 지정하자.
                */
    //2. 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //3.id를 이용하여 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    //join 메소드에서 뽑아낸 메소드
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 존재하는 회원입니다.");
                });
    }
}
