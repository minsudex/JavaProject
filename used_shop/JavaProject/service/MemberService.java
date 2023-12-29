package used_shop.JavaProject.service;

import used_shop.JavaProject.common.commonVariables;
import used_shop.JavaProject.dto.MemberDTO;
import used_shop.JavaProject.repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    Scanner scanner = new Scanner(System.in);
    public void save() {
        if(commonVariables.loginEmail == null) {
            String memberEmail = null;
            MemberDTO memberDTO = null;
            do {
                System.out.print("이메일: ");
                memberEmail = scanner.next();
                memberDTO = memberRepository.check(memberEmail);
                if (memberDTO == null) {
                    System.out.println("사용 가능한 이메일 입니다.");
                } else {
                    System.out.println("이미 사용 중인 이메일 입니다.");
                }
            } while (memberDTO != null);
            System.out.print("비밀번호: ");
            String memberPass = scanner.next();
            System.out.print("이름: ");
            String memberName = scanner.next();
            System.out.print("전화번호: ");
            String memberMobile = scanner.next();
            memberDTO = new MemberDTO(memberEmail, memberPass, memberName, memberMobile);
            boolean result = memberRepository.save(memberDTO);
            if (result) {
                System.out.println(memberDTO.getMemberEmail()+"님 회원가입에 축하합니다.");
            } else {
                System.out.println("등록에 실패하셨습니다.");
            }
        } else {
            System.out.println("로그아웃 후 사용해주세요.");
        }
    }


    public void findByEmail() {
        if(commonVariables.loginEmail != null) {
            System.out.print("확인용 이메일: ");
            String memberEmail = scanner.next();
            MemberDTO memberDTO = memberRepository.check(memberEmail);
            if (memberDTO != null) {
                System.out.println(memberDTO);
            } else {
                System.out.println("찾는 정보가 없습니다.");
            }
        } else {
            System.out.println("로그인 후 사용하세요.");
        }
    }

    public void update() {
        if (commonVariables.loginEmail != null) {
            System.out.print("확인용 이메일: ");
            String memberEmail = scanner.next();
            MemberDTO memberDTO = memberRepository.check(memberEmail);
            if (memberDTO != null) {
                System.out.print("수정할 전화번호: ");
                String memberMobile = scanner.next();
                System.out.print("수정할 비밀번호: ");
                String memberPass = scanner.next();
                boolean result = memberRepository.update(memberEmail, memberMobile, memberPass);
                if (result) {
                    System.out.println(memberDTO.getMemberEmail()+"님 수정에 성공하셨습니다.");
                } else {
                    System.out.println("수정에 실패하셨습니다.");
                }
            } else {
                System.out.println("없는 이메일 입니다.");
            }
        } else {
            System.out.println("로그인 후 사용하세요.");
        }
    }

    public void delete() {
        if (commonVariables.loginEmail != null) {
            System.out.print("확인용 이메일: ");
            String memberEmail = scanner.next();
            MemberDTO memberDTO = memberRepository.check(memberEmail);
            if (memberDTO != null) {
                System.out.println("정말 탈퇴하실겁니까?");
                System.out.println("탈퇴하길 원하시면 1번, 아니면 2번을 선택해주세요");
                int select = scanner.nextInt();
                if (select == 1) {
                    System.out.print("확인용 비밀번호: ");
                    String memberPass = scanner.next();
                    if(memberPass.equals(memberDTO.getMemberPass())) {
                        boolean result = memberRepository.delete(memberEmail, memberPass);
                        if (result) {
                            commonVariables.loginEmail = null;
                            System.out.println("탈퇴에 성공하셨습니다.");
                        } else {
                            System.out.println("탈퇴에 실패하셨습니다.");
                        }
                    } else {
                        System.out.println("비밀번호가 틀렸습니다.");
                    }
                } else if (select == 2) {
                    System.out.println("메인화면으로 돌아갑니다.");
                }
            } else {
                System.out.println("찾는 이메일이 없습니다.");
            }
        } else {
            System.out.println("로그인 후 사용하세요.");
        }

    }

    public void login() {
        if (commonVariables.loginEmail != null) {
            System.out.println("로그아웃 후 사용하세요.");
        } else {
            System.out.print("이메일: ");
            String memberEmail = scanner.next();
            MemberDTO memberDTO = memberRepository.check(memberEmail);
            if (memberDTO != null) {
                System.out.print("비밀번호: ");
                String memberPass = scanner.next();
                if (memberPass.equals(memberDTO.getMemberPass())) {
                    commonVariables.loginEmail = memberEmail;
                    System.out.println(memberDTO.getMemberEmail()+"님 환영합니다.");
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            } else {
                System.out.println("이메일이 틀렸습니다.");
            }
        }
    }

    public void logout() {
        if (commonVariables.loginEmail != null) {
            commonVariables.loginEmail = null;
            System.out.println("로그아웃 성공");
        } else {
            System.out.println("로그인 후 사용하세요.");
        }
    }

    public void market() {
        if (commonVariables.loginEmail != null) {
            MarketService marketService = new MarketService();
            if (commonVariables.loginEmail != null) {
                System.out.println("---------");
                System.out.println("마켓 관리");
                while (true) {
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    System.out.println("1.상품 등록 | 2.상품 확인 | 3.상품 수정 | 4.상품 삭제 | 5.돈 관리 | 6.상품 구매 | 7.상품 판매 | 0.종료");
                    System.out.println("---------------------------------------------------------------------------------------------------------");
                    System.out.print("선택> ");
                    int select = scanner.nextInt();
                    if (select == 1) {
                        marketService.save();
                    } else if (select == 2) {
                        marketService.findAll();
                    } else if (select == 3) {
                        marketService.update();
                    } else if (select == 4) {
                        marketService.delete();
                    } else if (select == 5) {
                        marketService.money();
                    } else if (select == 6) {
                        marketService.buy();
                    } else if (select == 7) {
                        marketService.sale();
                    } else if (select == 0) {
                        break;
                    }
                }
            }
        } else {
            System.out.println("로그인 후 사용하세요.");
        }
    }
}