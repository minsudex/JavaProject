package used_shop.JavaProject.service;

import used_shop.JavaProject.common.commonVariables;
import used_shop.JavaProject.dto.BoardDTO;
import used_shop.JavaProject.dto.ClientDTO;
import used_shop.JavaProject.dto.MarketDTO;
import used_shop.JavaProject.dto.AccountDTO;
import used_shop.JavaProject.repository.BoardRepository;
import used_shop.JavaProject.repository.MarketRepository;
import used_shop.JavaProject.repository.MoneyRepository;

import java.util.List;
import java.util.Scanner;

public class MarketService {
    MarketRepository marketRepository = new MarketRepository();
    BoardRepository boardRepository = new BoardRepository();
    MoneyRepository moneyRepository = new MoneyRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        System.out.print("등록할 물건: ");
        String objectName = scanner.next();
        System.out.print("가격: ");
        long objectPrice = scanner.nextLong();
        MarketDTO marketDTO = new MarketDTO(commonVariables.loginEmail, objectName, objectPrice, "X");
        boolean result = marketRepository.save(marketDTO);
        if (result) {
            System.out.println("등록에 성공하셨습니다.");
        } else {
            System.out.println("등록에 실패하셨습니다.");
        }
    }

    public void findAll() {
        List<MarketDTO> marketDTOList = marketRepository.findAll();
        marketlistPrint(marketDTOList);
    }

    public void update() {
        System.out.print("확인용 이메일: ");
        String memberEmail = scanner.next();
        List<MarketDTO> marketDTOList = marketRepository.findByEmail(memberEmail);
        if (marketDTOList.size() > 0) {
            marketlistPrint(marketDTOList);
            System.out.print("수정할 물건: ");
            String objectName = scanner.next();
            System.out.print("수정할 가격: ");
            long objectPrice = scanner.nextLong();
            boolean result = marketRepository.update(memberEmail, objectName, objectPrice);
            if (result) {
                System.out.println("수정에 성공하셨습니다.");
            } else {
                System.out.println("수정할 물건이 없습니다.");
            }
        } else {
            System.out.println("등록한 물건이 없습니다.");
        }
    }

    public void delete() {
        System.out.print("확인용 이메일: ");
        String memberEmail = scanner.next();
        List<MarketDTO> marketDTOList = marketRepository.findByEmail(memberEmail);
        if (marketDTOList.size() > 0) {
            marketlistPrint(marketDTOList);
            System.out.print("삭제할 물건: ");
            String objectName = scanner.next();
            boolean result = marketRepository.delete(memberEmail, objectName);
            if (result) {
                System.out.println("삭제에 성공하셨습니다.");
            } else {
                System.out.println("삭제에 실패하셨습니다.");
            }
        } else {
            System.out.println("없는 이메일 입니다.");
        }
    }

    public void money() {
        MoneyService moneyService = new MoneyService();
        while (true) {
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("1.계좌 등록 | 2.입금 | 3.입금 내역 | 4.출금 내역 | 5.모든 내역 | 6.잔액 확인 | 0.종료");
            System.out.println("------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                moneyService.save();
            } else if (select == 2) {
                moneyService.deposit();
            } else if (select == 3) {
                moneyService.findByDeposit();
            } else if (select == 4) {
                moneyService.findByWithdraw();
            } else if (select == 5) {
                moneyService.findAll();
            } else if (select == 6) {
                moneyService.findBalance();
            } else if (select == 0) {
                break;
            }
        }
    }

    public void buy() {
        System.out.println("물건 품목");
        System.out.println("---------");
        List<MarketDTO> marketDTOList = marketRepository.findAll();
        marketlistPrint(marketDTOList);
        System.out.println("거래하고 싶은 회원을 고르세요.");
        System.out.print("> ");
        String memberEmail = scanner.next();
        System.out.println("사고 싶은 물건을 고르세요.");
        System.out.print("> ");
        String objectName = scanner.next();
        MarketDTO marketDTO = marketRepository.buy(memberEmail, objectName);
        if (marketDTO != null) {
            List<BoardDTO> boardDTOList = boardRepository.findBoard(memberEmail, objectName);
            if (boardDTOList.size() > 0) {
                boardlistPrint(boardDTOList);
            } else {
                System.out.println("댓글이 없습니다.");
            }
            System.out.println("댓글쓰기를 원하면 1번, 아니면 2번을 선택해주세요.");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                System.out.println("거래에 사용할 계좌를 선택하세요.");
                System.out.print("계좌번호: ");
                String accoutNum = scanner.next();
                System.out.println("가격 제시와 댓글을 써주세요.");
                System.out.print("가격 제시: ");
                long objectPrice = scanner.nextLong();
                System.out.print("댓글: ");
                String boardContents = scanner.next();
                ClientDTO clientDTO = moneyRepository.priceCompare(commonVariables.loginEmail, objectPrice);
                if (clientDTO != null) {
                    BoardDTO boardDTO = new BoardDTO(memberEmail, objectName, commonVariables.loginEmail, objectPrice, boardContents);
                    boolean result = boardRepository.save(boardDTO);
                    if (result) {
                        AccountDTO accountDTO = new AccountDTO(commonVariables.loginEmail, accoutNum, 0, objectPrice);
                        moneyRepository.accountSave(accountDTO);
                        System.out.println("댓글 쓰기에 성공했습니다.");
                        System.out.println("잔고: "+clientDTO.getBalance());
                    } else {
                        System.out.println("댓글 쓰기에 실패했습니다.");
                    }
                } else {
                    System.out.println("돈이 부족합니다.");
                    System.out.println("돈을 입금하고 다시 가격을 제시하세요.");
                }
            } else if (select == 2) {
                System.out.println("메인 메뉴로 돌아갑니다.");
            }
        } else {
            System.out.println("찾는 물건이 없습니다.");
        }
    }

    public void sale() {
        System.out.print("올린품목 확인(이메일 입력): ");
        String memberEmail = scanner.next();
        if (memberEmail.equals(commonVariables.loginEmail)) {
            List<MarketDTO> marketDTOList = marketRepository.findByEmail(memberEmail);
            if (marketDTOList.size() > 0) {
                marketlistPrint(marketDTOList);
                System.out.print("판매할 물건: ");
                String objectName = scanner.next();
                System.out.println("댓글 확인");
                List<BoardDTO> boardDTOList = boardRepository.findBoard(memberEmail, objectName);
                boardlistPrint(boardDTOList);
                System.out.print("댓글 작성자 이메일: ");
                String boardEmail = scanner.next();
                System.out.print("마음에 드는 가격입력: ");
                long objectPrice = scanner.nextLong();
                BoardDTO boardDTO = boardRepository.sale(boardEmail, objectName);
                if (boardDTO != null) {
                    marketRepository.saleSituation(memberEmail, objectName);
                    System.out.print("판매액을 입금할 계좌: ");
                    String accountNum = scanner.next();
                    AccountDTO accountDTO = new AccountDTO(memberEmail, accountNum, objectPrice, 0);
                    moneyRepository.accountSave(accountDTO);
                    ClientDTO clientDTO = moneyRepository.deposit(commonVariables.loginEmail, accountNum, objectPrice);
                    System.out.println("잔고: "+clientDTO.getBalance());
                    System.out.println("판매완료");
                } else {
                    System.out.println("찾는 댓글이 없습니다.");
                }
            } else {
                System.out.println("등록한 물건이 없습니다.");
            }
        } else {
            System.out.println("자신의 판매 물품만 볼 수 있습니다.");
        }
    }

    private void marketlistPrint(List<MarketDTO> marketDTOList) {
        System.out.println("id\t" + "seller\t" + "objectName\t" + "objectPrice\t" + "saleSituation\t" + "createdAt\t");
        for (MarketDTO marketDTO: marketDTOList) {
            System.out.println(marketDTO.getId() + "\t" + marketDTO.getMemberEmail() +
                    "\t" + marketDTO.getObjectName() + "\t" + marketDTO.getObjectPrice() + "\t"
                    + marketDTO.getSaleSituation() + "\t" + marketDTO.getCreatedAt() + "\t");
        }
    }

    private void boardlistPrint(List<BoardDTO> boardDTOList) {
        System.out.println("id\t" + "purchaser\t" + "objectName\t" + "objectPrice\t" + "boardContents\t" + "createdAt\t");
        for (BoardDTO boardDTO: boardDTOList) {
            System.out.println(boardDTO.getId() + "\t" + boardDTO.getBoardEmail() +
                    "\t" + boardDTO.getObjectName() + "\t" + boardDTO.getObjectPrice() + "\t"
                    + boardDTO.getBoardContents() + boardDTO.getCreatedAt() + "\t");
        }
    }
}