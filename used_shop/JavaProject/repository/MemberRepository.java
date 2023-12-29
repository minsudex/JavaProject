package used_shop.JavaProject.repository;

import used_shop.JavaProject.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    private static List<MemberDTO> memberDTOList = new ArrayList<>();
    public MemberDTO check(String memberEmail) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                return memberDTOList.get(i);
            }
        }
        return null;
    }

    public boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }

    public boolean update(String memberEmail, String memberMobile, String memberPass) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail())) {
                memberDTOList.get(i).setMemberMobile(memberMobile);
                memberDTOList.get(i).setMemberPass(memberPass);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String memberEmail, String memberPass) {
        for (int i = 0; i < memberDTOList.size(); i++) {
            if (memberEmail.equals(memberDTOList.get(i).getMemberEmail()) && memberPass.equals(memberDTOList.get(i).getMemberPass())) {
                memberDTOList.remove(i);
                return true;
            }
        }
        return false;
    }
}