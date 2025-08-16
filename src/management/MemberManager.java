package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

import java.util.Currency;
import java.util.HashMap;

public class MemberManager {
    public CustomHashMap<String, Member> getMembers() {
        return members;
    }

    private CustomHashMap<String, Member> members;

    public MemberManager() {
        members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
        //System.out.println(members);
    }

    public Member getMember(String memberId) {
        //System.out.println(memberId);
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        getMember(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        return getMember(memberId).getLastTransaction();
    }
}
