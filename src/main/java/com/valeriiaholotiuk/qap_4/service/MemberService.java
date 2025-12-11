package com.valeriiaholotiuk.qap_4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valeriiaholotiuk.qap_4.model.Member;
import com.valeriiaholotiuk.qap_4.repository.MemberRepository;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new RuntimeException("Member with email already exists");
        }
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }
}
