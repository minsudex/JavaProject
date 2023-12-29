package used_shop.JavaProject.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarketDTO {
    private Long id;
    private String memberEmail;
    private String objectName;
    private long objectPrice;
    private String saleSituation;
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

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public long getObjectPrice() {
        return objectPrice;
    }

    public void setObjectPrice(long objectPrice) {
        this.objectPrice = objectPrice;
    }

    public String getSaleSituation() {
        return saleSituation;
    }

    public void setSaleSituation(String saleSituation) {
        this.saleSituation = saleSituation;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public MarketDTO () {

    }

    private static Long idValue = 1L;

    public MarketDTO(String memberEmail, String objectName, long objectPrice, String saleSituation) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.objectName = objectName;
        this.objectPrice = objectPrice;
        this.saleSituation = saleSituation;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "MarketDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", objectName='" + objectName + '\'' +
                ", objectPrice=" + objectPrice +
                ", saleSituation='" + saleSituation + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}