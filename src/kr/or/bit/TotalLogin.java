package kr.or.bit;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class TotalLogin {
   
    Admin admin = new Admin();
    HashMap<String, String> userList = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    
    public void showMenu() { // 메뉴 보여주기
        while(true) {       
        String selection;
        System.out.println("------------------------");
        System.out.println("        비트아트센터              ");
        System.out.println("------------------------");
        System.out.println("  원하는 메뉴 번호를 입력하세요   ");
        System.out.println("------------------------");
        System.out.println("       1.회원 로그인               ");
        System.out.println("       2.관리자 로그인             ");
        System.out.println("       0.프로그램 종료            ");
        System.out.println("------------------------");
        selection = scanner.next();
        switch (selection) {
        case "1" : 
            loginCustomer();
            break; 
        case "2" :
            loginAdmin();
            break;
        case "0" :
            System.out.println("프로그램 종료");
            System.exit(0);
        default:
            System.out.println("잘못된 입력! 1, 2, 0 중에 하나를 입력하세요!");
            break;
        }
        }
    }//showMenu() End
    
    
    
    private void loginCustomer() { //회원 로그인//menu에서 1.회원로그인시 이 함수호출 

        String customId;
        String customPwd;

        String idRegExp = "^[A-Za-z]{6,12}+$"; //영문으로만 만들되 최소 6자에서 최대 12자
        String pwdRegExp = "^[0-9]{4,8}+$"; //숫자로만 만들되 최소 4자에서 최대 8자
        
        while(true) {
            
            System.out.println("예매에 쓸 ID를 설정합니다. *조건 : 알파벳으로만, 최소 6자~최대 12자");
            System.out.println("입력>> ");
            customId = scanner.next();
            System.out.println("예매에 쓸 비밀번호를 설정합니다. *조건: 숫자로만, 최소 4자~최대 8자");
            System.out.println("입력>> ");
            customPwd = scanner.next();
        
                if(customId.matches(idRegExp) && customPwd.matches(pwdRegExp)) {
                	userList.put(customId, customPwd);
                    showCustomerMenu(admin);
                    break;
                } else {
                    System.out.println("잘못된 양식입니다. 조건을 확인하세요!");
                    continue;
            }
        }
    } //loginCustomer() End
        
    private void showCustomerMenu(Admin admin) {
        
        Customer customer = new Customer();
        
        Loop: while(true) {
        System.out.println("*******환영합니다!*******");
        System.out.println("1.예매");
        System.out.println("2.예매 취소");
        System.out.println("3.예매 확인");
        System.out.println("4.회원 탈퇴");
        System.out.println("5.메인메뉴로 돌아가기");
        System.out.println("0.프로그램 종료");
        System.out.println("원하는 메뉴 번호를 입력하세요>> ");
        String customNum = scanner.next();
        switch (customNum) {
        case "1" : //예매(안됨)
            customer.reserve(admin);
            break;
        case "2" : //예매취소(안됨)**********************
            customer.cancelReserve(admin);
            break;
        case "3" : //예매확인(안됨)
            customer.checkReserve();
            break;
        case "4" : //회원탈퇴(됨)
            deleteUser();
            break Loop;
        case "5" : //메인 메뉴로 돌아가기
            System.out.println("메인메뉴로 돌아가기");
            break Loop;
        case "0" : //프로그램 종료
            System.out.println("프로그램 종료");
            System.exit(0);
        default:
            break;
        }   
        }
    } //showCustomerMenu() End
    
    private void deleteUser() {
        System.out.println("회원탈퇴를 하시겠습니까?");
        System.out.println("1. 예");
        System.out.println("2. 아니요");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        switch (a) {
        case "1":
                System.out.println("탈퇴 되었습니다.");
                userList.clear();
            return;
        case "2":
            System.out.println("탈퇴 취소!");
            return;
        default:
            System.out.println("잘못 입력 하셨습니다.");
            break;
        }
    } //deleteUser() End
    
    private void loginAdmin() { //관리자 로그인 //menu에서 2.관리자로그인시 이 함수호출 
        
        final String ADMIN_ID = "admin";
        final String ADMIN_PWD = "1234";
        String inputAdminId;
        String inputAdminPwd;

        while(true) {
            
            System.out.println("ID를 입력하세요: ");
            inputAdminId = scanner.next();
            System.out.println("비밀번호를 입력하세요: ");
            inputAdminPwd = scanner.next();

            if(inputAdminId.equals(ADMIN_ID)) { //아이디가 맞다
                if (inputAdminPwd.equals(ADMIN_PWD)) { //비밀번호도 맞다
                    showAdminMenu(admin);
                    break;
                } else { //아이디는 맞는데 비밀번호가 틀렸다
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            } else { //아이디가 틀렸다.
                System.out.println("ID가 틀렸습니다.");
                continue;
            }
        }       
    } //loginAdmin End
    
    
    private void showAdminMenu(Admin admin) {
        
        Loop: while(true) {
        
        System.out.println("*******환영합니다!*******");
        System.out.println("1.공연 개설");
        System.out.println("2.공연 수정");
        System.out.println("3.공연 취소");
        System.out.println("4.공연 개설 목록 확인");
        System.out.println("5.총 매출 확인");
        System.out.println("6.메인 메뉴로 돌아가기");
        System.out.println("0.프로그램 종료");
        System.out.println("원하는 메뉴 번호를 입력하세요>> ");
        
        String adminNum = scanner.next();
        switch (adminNum) {
        case "1": //공연개설
            admin.addConcert();
            break;
        case "2": //공연수정
            admin.reviseShow();
            break;
        case "3": //공연취소
            admin.cancelShow();
            break;
        case "4": //공연개설목록확인
            admin.checkList();
            break;
        case "5": //총매출확인
            admin.checkBalance();
            break;
        case "6" : //메인 메뉴로 돌아가기
            System.out.println("메인 메뉴로 돌아가기");
            break Loop;
        case "0": //프로그램 종료
            System.out.println("프로그램 종료");
            System.exit(0);
        default:
            break;
        }
        }
    } //showAdminMenu() End
    
   
    
}//TotalLogin End
