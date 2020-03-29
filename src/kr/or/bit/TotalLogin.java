package kr.or.bit;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class TotalLogin {
   
    Admin admin = new Admin();
    HashMap<String, String> userList = new HashMap<String, String>();
    Scanner scanner = new Scanner(System.in);
    
    public void showMenu() { // �޴� �����ֱ�
        while(true) {       
        String selection;
        System.out.println("------------------------");
        System.out.println("        ��Ʈ��Ʈ����              ");
        System.out.println("------------------------");
        System.out.println("  ���ϴ� �޴� ��ȣ�� �Է��ϼ���   ");
        System.out.println("------------------------");
        System.out.println("       1.ȸ�� �α���               ");
        System.out.println("       2.������ �α���             ");
        System.out.println("       0.���α׷� ����            ");
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
            System.out.println("���α׷� ����");
            System.exit(0);
        default:
            System.out.println("�߸��� �Է�! 1, 2, 0 �߿� �ϳ��� �Է��ϼ���!");
            break;
        }
        }
    }//showMenu() End
    
    
    
    private void loginCustomer() { //ȸ�� �α���//menu���� 1.ȸ���α��ν� �� �Լ�ȣ�� 

        String customId;
        String customPwd;

        String idRegExp = "^[A-Za-z]{6,12}+$"; //�������θ� ����� �ּ� 6�ڿ��� �ִ� 12��
        String pwdRegExp = "^[0-9]{4,8}+$"; //���ڷθ� ����� �ּ� 4�ڿ��� �ִ� 8��
        
        while(true) {
            
            System.out.println("���ſ� �� ID�� �����մϴ�. *���� : ���ĺ����θ�, �ּ� 6��~�ִ� 12��");
            System.out.println("�Է�>> ");
            customId = scanner.next();
            System.out.println("���ſ� �� ��й�ȣ�� �����մϴ�. *����: ���ڷθ�, �ּ� 4��~�ִ� 8��");
            System.out.println("�Է�>> ");
            customPwd = scanner.next();
        
                if(customId.matches(idRegExp) && customPwd.matches(pwdRegExp)) {
                	userList.put(customId, customPwd);
                    showCustomerMenu(admin);
                    break;
                } else {
                    System.out.println("�߸��� ����Դϴ�. ������ Ȯ���ϼ���!");
                    continue;
            }
        }
    } //loginCustomer() End
        
    private void showCustomerMenu(Admin admin) {
        
        Customer customer = new Customer();
        
        Loop: while(true) {
        System.out.println("*******ȯ���մϴ�!*******");
        System.out.println("1.����");
        System.out.println("2.���� ���");
        System.out.println("3.���� Ȯ��");
        System.out.println("4.ȸ�� Ż��");
        System.out.println("5.���θ޴��� ���ư���");
        System.out.println("0.���α׷� ����");
        System.out.println("���ϴ� �޴� ��ȣ�� �Է��ϼ���>> ");
        String customNum = scanner.next();
        switch (customNum) {
        case "1" : //����(�ȵ�)
            customer.reserve(admin);
            break;
        case "2" : //�������(�ȵ�)**********************
            customer.cancelReserve(admin);
            break;
        case "3" : //����Ȯ��(�ȵ�)
            customer.checkReserve();
            break;
        case "4" : //ȸ��Ż��(��)
            deleteUser();
            break Loop;
        case "5" : //���� �޴��� ���ư���
            System.out.println("���θ޴��� ���ư���");
            break Loop;
        case "0" : //���α׷� ����
            System.out.println("���α׷� ����");
            System.exit(0);
        default:
            break;
        }   
        }
    } //showCustomerMenu() End
    
    private void deleteUser() {
        System.out.println("ȸ��Ż�� �Ͻðڽ��ϱ�?");
        System.out.println("1. ��");
        System.out.println("2. �ƴϿ�");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        switch (a) {
        case "1":
                System.out.println("Ż�� �Ǿ����ϴ�.");
                userList.clear();
            return;
        case "2":
            System.out.println("Ż�� ���!");
            return;
        default:
            System.out.println("�߸� �Է� �ϼ̽��ϴ�.");
            break;
        }
    } //deleteUser() End
    
    private void loginAdmin() { //������ �α��� //menu���� 2.�����ڷα��ν� �� �Լ�ȣ�� 
        
        final String ADMIN_ID = "admin";
        final String ADMIN_PWD = "1234";
        String inputAdminId;
        String inputAdminPwd;

        while(true) {
            
            System.out.println("ID�� �Է��ϼ���: ");
            inputAdminId = scanner.next();
            System.out.println("��й�ȣ�� �Է��ϼ���: ");
            inputAdminPwd = scanner.next();

            if(inputAdminId.equals(ADMIN_ID)) { //���̵� �´�
                if (inputAdminPwd.equals(ADMIN_PWD)) { //��й�ȣ�� �´�
                    showAdminMenu(admin);
                    break;
                } else { //���̵�� �´µ� ��й�ȣ�� Ʋ�ȴ�
                    System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
                }
            } else { //���̵� Ʋ�ȴ�.
                System.out.println("ID�� Ʋ�Ƚ��ϴ�.");
                continue;
            }
        }       
    } //loginAdmin End
    
    
    private void showAdminMenu(Admin admin) {
        
        Loop: while(true) {
        
        System.out.println("*******ȯ���մϴ�!*******");
        System.out.println("1.���� ����");
        System.out.println("2.���� ����");
        System.out.println("3.���� ���");
        System.out.println("4.���� ���� ��� Ȯ��");
        System.out.println("5.�� ���� Ȯ��");
        System.out.println("6.���� �޴��� ���ư���");
        System.out.println("0.���α׷� ����");
        System.out.println("���ϴ� �޴� ��ȣ�� �Է��ϼ���>> ");
        
        String adminNum = scanner.next();
        switch (adminNum) {
        case "1": //��������
            admin.addConcert();
            break;
        case "2": //��������
            admin.reviseShow();
            break;
        case "3": //�������
            admin.cancelShow();
            break;
        case "4": //�����������Ȯ��
            admin.checkList();
            break;
        case "5": //�Ѹ���Ȯ��
            admin.checkBalance();
            break;
        case "6" : //���� �޴��� ���ư���
            System.out.println("���� �޴��� ���ư���");
            break Loop;
        case "0": //���α׷� ����
            System.out.println("���α׷� ����");
            System.exit(0);
        default:
            break;
        }
        }
    } //showAdminMenu() End
    
   
    
}//TotalLogin End