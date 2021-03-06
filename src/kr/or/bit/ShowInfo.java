package kr.or.bit;


public class ShowInfo { 
	public String[][] seat; //좌석정보 
    private String showType; //공연 종류
    private String showDate;
    private String startShow;
    private String endShow;
    private String period;
    
    ShowInfo(){}; // 기본 생성자 추가
    
    public ShowInfo(String showType, String showDate, String startShow, String endShow, String period) {
        this.showType = showType;
        this.showDate = showDate;
        this.startShow = startShow;
        this.endShow = endShow;
        this.period = period;
        
        seat = new String[4][5];
        for(int i=0; i<seat.length; i++) {
            for(int j=0; j<seat[i].length; j++) {
                seat[i][j] = "____";
            }       
        }
    }
    
    //좌석정보 보여주기
     public void seatInfo() {
            for (int i = 0; i < seat.length; i++) {
                for (int j = 0; j < seat[i].length; j++) {
                    System.out.printf("[%s]", seat[i][j].equals("____") ? "예매가능" : "자리없음");
                }
                System.out.println();
            }
        }
         
        public String getShowType() {
            return showType;
        }

        public String getShowDate() {
            return showDate;
        }

        public String getStartShow() {
            return startShow;
        }

        public String getEndShow() {
            return endShow;
        }

        public String getPeriod() {
            return period;
        }
        
        public void setStartShow(String startShow) {
            this.startShow = startShow;
        }

        public void setEndShow(String endShow) {
            this.endShow = endShow;
        }

        @Override
        public String toString() {
            return "[ShowType=" + showType + ", showDate=" + showDate + ", startShow=" + startShow + ", endShow="
                    + endShow + ", period=" + period + "]\n";
        }
    
}//ShowInfo End
