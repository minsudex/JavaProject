package used_shop.JavaProject.service;

import used_shop.JavaProject.common.commonVariables;
import used_shop.JavaProject.dto.ClientDTO;
import used_shop.JavaProject.dto.AccountDTO;
import used_shop.JavaProject.repository.MoneyRepository;

import java.util.List;
import java.util.Scanner;

public class MoneyService {
    MoneyRepository moneyRepository = new MoneyRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        System.out.print("계좌 번호: ");
        String accountNum = scanner.next();
        System.out.print("비밀 번호: ");
        String accountPass = scanner.next();
        ClientDTO clientDTO = new ClientDTO(commonVariables.loginEmail, accountNum, accountPass);
        boolean result = moneyRepository.save(clientDTO);
        if (result) {
            System.out.println("계좌 등록에 성공했습니다.");
        } else {
            System.out.println("계좌 등록에 실패했습니다.");
        }
    }
    public void deposit() {
        System.out.print("계좌 번호: ");
        String accountNum = scanner.next();
        System.out.print("입금할 돈: ");
        long depositMoney = scanner.nextLong();
        AccountDTO accountDTO = new AccountDTO(commonVariables.loginEmail, accountNum, depositMoney, 0);
        boolean result = moneyRepository.accountSave(accountDTO);
        if (result && accountNum.equals(accountDTO.getAccountNum())) {
            ClientDTO clientDTO = moneyRepository.deposit(commonVariables.loginEmail, accountNum, depositMoney);
            if (clientDTO != null) {
                System.out.println("입금에 성공하셨습니다.");
                System.out.println("잔고: "+clientDTO.getBalance());
            } else {
                System.out.println("입금에 실패하셨습니다.");
            }
        } else {
            System.out.println("계좌 번호가 틀립니다.");
        }
    }


    public void findByDeposit() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            System.out.print("확인할 계좌번호: ");
            String accountNum = scanner.next();
            List<AccountDTO> accountDTOList = moneyRepository.findByDeposit(memberEmail, accountNum);
            if (accountDTOList.size() > 0) {
                for (AccountDTO accountDTO: accountDTOList) {
                    System.out.println(accountDTO);
                }
            } else {
                System.out.println("입금 내역이 없습니다.");
            }
        } else {
            System.out.println("자신의 계좌만 확인할 수 있습니다.");
        }
    }

    public void findByWithdraw() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            System.out.print("확인할 계좌번호: ");
            String accountNum = scanner.next();
            List<AccountDTO> accountDTOList = moneyRepository.findByWithdraw(memberEmail, accountNum);
            if (accountDTOList.size() > 0) {
                for (AccountDTO accountDTO: accountDTOList) {
                    System.out.println(accountDTO);
                }
            } else {
                System.out.println("출금 내역이 없습니다.");
            }
        } else {
            System.out.println("자신의 계좌만 확인할 수 있습니다.");
        }
    }

    public void findAll() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            System.out.print("확인할 계좌번호: ");
            String accountNum = scanner.next();
            List<AccountDTO> accountDTOList = moneyRepository.findAll(memberEmail, accountNum);
            if (accountDTOList.size() > 0) {
                for (AccountDTO accountDTO: accountDTOList) {
                    System.out.println(accountDTO);
                }
            } else {
                System.out.println("내역이 없습니다.");
            }
        } else {
            System.out.println("자신의 계좌만 확인할 수 있습니다.");
        }
    }

    public void findBalance() {
        System.out.print("확인할 이메일: ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            System.out.print("확인할 계좌번호: ");
            String accountNum = scanner.next();
            ClientDTO clientDTO = moneyRepository.findBalance(memberEmail, accountNum);
            if (clientDTO != null) {
                System.out.println("잔고: " + clientDTO.getBalance());
            } else {
                System.out.println("계좌번호가 없습니다.");
            }
        } else {
            System.out.println("자신의 계좌만 확인할 수 있습니다.");
        }
    }
}