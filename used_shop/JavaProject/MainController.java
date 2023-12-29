package used_shop.JavaProject;

import project.service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.println("1.회원 가입 | 2.회원 정보 확인 | 3.회원 정보 수정 | 4.회원 탈퇴 | 5.로그인 | 6.로그아웃 | 7.중고마켓 입장 | 0.종료");
            System.out.println("------------------------------------------------------------------------------------------------------");
            System.out.print("선택> ");
            int select = scanner.nextInt();
            if (select == 1) {
                memberService.save();
            } else if (select == 2) {
                memberService.findByEmail();
            } else if (select == 3) {
                memberService.update();
            } else if (select == 4) {
                memberService.delete();
            } else if (select == 5) {
                memberService.login();
            } else if (select == 6) {
                memberService.logout();
            } else if (select == 7) {
                memberService.market();
            } else if (select == 0) {
                break;
            }
        }
    }
}