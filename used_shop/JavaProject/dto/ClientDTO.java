package used_shop.JavaProject.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientDTO {
    private Long id;
    private String clientName;
    private String accountNum;
    private String accountPass;
    private String createdAt;
    private long balance = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountPass() {
        return accountPass;
    }

    public void setAccountPass(String accountPass) {
        this.accountPass = accountPass;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public ClientDTO() {

    }

    private static Long idValue = 1L;

    public ClientDTO(String clientName, String accountNum, String accountPass) {
        this.id = idValue++;
        this.clientName = clientName;
        this.accountNum = accountNum;
        this.accountPass = accountPass;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", accountNum='" + accountNum + '\'' +
                ", accountPass='" + accountPass + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}