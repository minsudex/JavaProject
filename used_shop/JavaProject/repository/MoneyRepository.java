package used_shop.JavaProject.repository;

import used_shop.JavaProject.dto.ClientDTO;
import used_shop.JavaProject.dto.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class MoneyRepository {
    private static List<AccountDTO> accountDTOList = new ArrayList<>();
    private static List<ClientDTO> clientDTOList = new ArrayList<>();

    public boolean save(ClientDTO clientDTO) {
        return clientDTOList.add(clientDTO);
    }


    public boolean accountSave(AccountDTO accountDTO) {
        return accountDTOList.add(accountDTO);
    }

    public ClientDTO deposit(String loginEmail, String accountNum, long depositMoney) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(loginEmail.equals(clientDTOList.get(i).getClientName()) && accountNum.equals(clientDTOList.get(i).getAccountNum())) {
                long balance = clientDTOList.get(i).getBalance();
                balance = balance + depositMoney;
                clientDTOList.get(i).setBalance(balance);
                return clientDTOList.get(i);
            }
        }
        return null;
    }

    public List<AccountDTO> findByDeposit(String memberEmail, String accountNum) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if(memberEmail.equals(accountDTOList.get(i).getMemberEmail()) && accountNum.equals(accountDTOList.get(i).getAccountNum())) {
                if (accountDTOList.get(i).getDeposit() > 0) {
                    accountDTOS.add(accountDTOList.get(i));
                }
            }
        }
        return accountDTOS;
    }

    public List<AccountDTO> findByWithdraw(String memberEmail, String accountNum) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if(memberEmail.equals(accountDTOList.get(i).getMemberEmail()) && accountNum.equals(accountDTOList.get(i).getAccountNum())) {
                if (accountDTOList.get(i).getWithdraw() > 0) {
                    accountDTOS.add(accountDTOList.get(i));
                }
            }
        }
        return accountDTOS;
    }

    public List<AccountDTO> findAll(String memberEmail, String accountNum) {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        for (int i = 0; i < accountDTOList.size(); i++) {
            if(memberEmail.equals(accountDTOList.get(i).getMemberEmail()) && accountNum.equals(accountDTOList.get(i).getAccountNum())) {
                accountDTOS.add(accountDTOList.get(i));
            }
        }
        return accountDTOS;
    }


    public ClientDTO priceCompare(String loginEmail, long objectPrice) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(loginEmail.equals(clientDTOList.get(i).getClientName())) {
                if (objectPrice <= clientDTOList.get(i).getBalance()) {
                    long balance = clientDTOList.get(i).getBalance();
                    balance = balance - objectPrice;
                    clientDTOList.get(i).setBalance(balance);
                    return clientDTOList.get(i);
                }
            }
        }
        return null;
    }


    public ClientDTO findBalance(String memberEmail, String accountNum) {
        for (int i = 0; i < clientDTOList.size(); i++) {
            if(memberEmail.equals(clientDTOList.get(i).getClientName()) && accountNum.equals(clientDTOList.get(i).getAccountNum())) {
                return clientDTOList.get(i);
            }
        }
        return null;
    }
}