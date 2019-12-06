package kr.ac.dongyang.dfgg.common;

// SQL LIMIT 시작데이터, 출력한 데이터의 개수
public class Criteria {

    // 현재 페이지 번호
    private int page;

    // 한 페이지당 출력되는 게시글 개수
    private int perPageNum;

    // Criteria 객체가 생성될때 기본 페이지 1, 게시글은 10개를 보여줌
    public Criteria() {
        this.page = 1;
        this.perPageNum = 10;
    }

    public int getPage() {
        return page;
    }

    // 음수값이 들어오지 않도록 체크
    public void setPage(int page) {

        if (page <= 0) {
            this.page = 1;
            return;
        }

        this.page = page;
    }

    public int getPerPageNum() {
        return perPageNum;
    }

    public void setPerPageNum(int perPageNum) {
        if (perPageNum <= 0 || perPageNum > 100) {
            this.perPageNum = 10;
            return;
        }

        this.perPageNum = perPageNum;
    }


    // Mybatis의 #{} 문법은 기본적으로 자바의 get메소드를 호출
    // Mapper에서 호출할 메소드 정의
    // 공식 ) 현재 페이지의 시작 게시글 번호 = ( 현재 페이지 번호 - 1 ) * 페이지 당 출력한 게시글의 개수
    public int getPageStart() {
        return (this.page - 1) * perPageNum;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "page=" + page +
                ", perPageNum=" + perPageNum +
                '}';
    }
}
