package kr.or.bit;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reservation { //���� 
    
    public Reservation() {
    }
    
    public Reservation(String customId,int price,int num){
    	this.customId = customId;
    	this.date = simpledateformat.format(calendar.getTime());
    	this.price = price;
    	this.num = num;
    } 
    
    
    private String customId; //ȸ�� ���̵�
    private String date; //���� ����
    private int price; //������
    private int num; //���Ź�ȣ
    
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm��");
    
    public void reservationBallet1() {
        this.date = simpledateformat.format(calendar.getTime());
        this.num = (int)(Math.random()*100000)+500000;
        this.price = 30000;
        
    }
    
    public String getCustomId() {
        return customId;
    }

    public int getPrice() {
        return price;
    }
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public int getNum() {
        return num;
    }
    
	public String getDate() {
		return date;
	}
	@Override
	public String toString() {
		return "Reservation [customId=" + customId + ", date=" + date + ", price=" + price + ", num=" + num + "]";
	}
    
    
}//Reservation End
