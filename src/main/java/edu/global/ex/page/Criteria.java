package edu.global.ex.page;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Criteria {
    private int pageNum; // 페이지 번호
    private int amount; // 한페이지당 몇개의 테이터를 보여줄 것인가?
    
    private String type;
    private String keyword;

    public Criteria() {
        this(1, 10, "", ""); // 기본값 1페이지 10개로 지정
    }

    public Criteria(int pageNum, int amount, String type, String keyword) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.type = type;
        this.keyword = keyword;
    }
    
}