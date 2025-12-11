package com.valeriiaholotiuk.qap_4.service;

import java.time.LocalDate;
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
            throw new IllegalArgumentException("Member with email already exists: " + member.getEmail());
        }
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    public List<Member> searchMembers(String name, String phone, LocalDate startDate) {
        if (name != null && !name.isBlank()) {
            return memberRepository.findByNameContainingIgnoreCase(name);
        }
        if (phone != null && !phone.isBlank()) {
            return memberRepository.findByPhoneNumber(phone);
        }
        if (startDate != null) {
            return memberRepository.findByMembershipStartDate(startDate);
        }

        return memberRepository.findAll();
    }
}
