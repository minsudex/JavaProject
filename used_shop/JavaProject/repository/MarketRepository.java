package used_shop.JavaProject.repository;

import used_shop.JavaProject.dto.MarketDTO;

import java.util.ArrayList;
import java.util.List;

public class MarketRepository {
    private static List<MarketDTO> marketDTOList = new ArrayList<>();

    public boolean save(MarketDTO marketDTO) {
        return marketDTOList.add(marketDTO);
    }

    public List<MarketDTO> findAll() {
        return marketDTOList;
    }

    public List<MarketDTO> findByEmail(String memberEmail) {
        List<MarketDTO> marketDTOS = new ArrayList<>();
        for (int i = 0; i < marketDTOList.size(); i++) {
            if(memberEmail.equals(marketDTOList.get(i).getMemberEmail())) {
                marketDTOS.add(marketDTOList.get(i));
            }
        }
        return marketDTOS;
    }

    public boolean update(String memberEmail, String objectName, long objectPrice) {
        for (int i = 0; i < marketDTOList.size(); i++) {
            if(memberEmail.equals(marketDTOList.get(i).getMemberEmail()) && objectName.equals(marketDTOList.get(i).getObjectName())) {
                marketDTOList.get(i).setObjectPrice(objectPrice);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String memberEmail, String objectName) {
        for (int i = 0; i < marketDTOList.size(); i++) {
            if(memberEmail.equals(marketDTOList.get(i).getMemberEmail()) && objectName.equals(marketDTOList.get(i).getObjectName())) {
                marketDTOList.remove(i);
                return true;
            }
        }
        return false;
    }

    public MarketDTO buy(String memberEmail, String objectName) {
        for (int i = 0; i < marketDTOList.size(); i++) {
            if(memberEmail.equals(marketDTOList.get(i).getMemberEmail()) && objectName.equals(marketDTOList.get(i).getObjectName())) {
                return marketDTOList.get(i);
            }
        }
        return null;
    }

    public void saleSituation(String memberEmail, String objectName) {
        for (int i = 0; i < marketDTOList.size(); i++) {
            if(memberEmail.equals(marketDTOList.get(i).getMemberEmail()) && objectName.equals(marketDTOList.get(i).getObjectName())) {
                marketDTOList.get(i).setSaleSituation("O");
            }
        }
    }
}