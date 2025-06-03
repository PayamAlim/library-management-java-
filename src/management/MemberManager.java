package management;

import library.Member;
import library.Transaction;

import java.util.HashMap;

public class MemberManager {
    private HashMap<String, Member> members;

    public MemberManager() {
        members = new HashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        getMember(memberId).addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        return getMember(memberId).getLastTransaction();
    }
}
