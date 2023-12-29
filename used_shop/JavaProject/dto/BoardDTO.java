package used_shop.JavaProject.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BoardDTO {
    private Long id;
    private String memberEmail;
    private String objectName;
    private String boardEmail;
    private long objectPrice;
    private String boardContents;
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

    public String getBoardEmail() {
        return boardEmail;
    }

    public void setBoardEmail(String boardEmail) {
        this.boardEmail = boardEmail;
    }

    public long getObjectPrice() {
        return objectPrice;
    }

    public void setObjectPrice(long objectPrice) {
        this.objectPrice = objectPrice;
    }

    public String getBoardContents() {
        return boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public BoardDTO() {

    }

    private static Long idValue = 1L;

    public BoardDTO(String memberEmail, String objectName, String boardEmail, long objectPrice, String boardContents) {
        this.id = idValue++;
        this.memberEmail = memberEmail;
        this.objectName = objectName;
        this.boardEmail = boardEmail;
        this.objectPrice = objectPrice;
        this.boardContents = boardContents;
        this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "id=" + id +
                ", memberEmail='" + memberEmail + '\'' +
                ", objectName='" + objectName + '\'' +
                ", boardEmail='" + boardEmail + '\'' +
                ", objectPrice=" + objectPrice +
                ", boardContents='" + boardContents + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}