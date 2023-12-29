package used_shop.JavaProject.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPass;
    private String memberName;
    private String memberMobile;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public MemberDTO() {

    }

    private static Long idValue = 1L;

    public MemberDTO(String memberEmail, String memberPass, String memberName, String memberMobile) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.memberPass = memberPass;
        this.memberName = memberName;
        this.memberMobile = memberMobile;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPass='" + memberPass + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}