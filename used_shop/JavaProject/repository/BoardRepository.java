package used_shop.JavaProject.repository;

import used_shop.JavaProject.dto.BoardDTO;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    private static List<BoardDTO> boardDTOList = new ArrayList<>();


    public boolean save(BoardDTO boardDTO) {
        return boardDTOList.add(boardDTO);
    }

    public List<BoardDTO> findBoard(String memberEmail, String objectName) {
        List<BoardDTO> boardDTOS = new ArrayList<>();
        for (int i = 0; i < boardDTOList.size(); i++) {
            if (memberEmail.equals(boardDTOList.get(i).getMemberEmail()) && objectName.equals(boardDTOList.get(i).getObjectName())) {
                boardDTOS.add(boardDTOList.get(i));
            }
        }
        return boardDTOS;
    }

    public BoardDTO sale(String boardEmail, String objectName) {
        for (int i = 0; i < boardDTOList.size(); i++) {
            if(boardEmail.equals(boardDTOList.get(i).getBoardEmail()) && objectName.equals(boardDTOList.get(i).getObjectName())) {
                return boardDTOList.get(i);
            }
        }
        return null;
    }

}