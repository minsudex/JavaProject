package used_shop.JavaProject.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountDTO {
    private Long id;
    private String accountNum;
    private String memberEmail;
    private long deposit;
    private long withdraw;
    private String createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }


    public long getDeposit() {
        return deposit;
    }

    public void setDeposit(long deposit) {
        this.deposit = deposit;
    }

    public long getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(long withdraw) {
        this.withdraw = withdraw;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public AccountDTO() {

    }

    private static Long idValue = 1L;

    public AccountDTO(String memberEmail, String accountNum, long deposit, long withdraw) {
        this.id = idValue++;
        this.accountNum = accountNum;
        this.memberEmail = memberEmail;
        this.deposit = deposit;
        this.withdraw = withdraw;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", accountNum='" + accountNum + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", deposit=" + deposit +
                ", withdraw=" + withdraw +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}