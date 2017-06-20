package com.choa.util;

public class ListInfo {

	private Integer curPage; //Null 이 올 수 있기 때문에 Integer
	private String search;
	private String find;
	private Integer perPage;
	private int startRow;
	private int lastRow;
	
	//페이징 처리하기 위한 변수 4가지
	private int curBlock;
	private int totalBlock;
	
	
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getLastNum() {
		return lastNum;
	}

	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	
	public int getTotalBlock() {
		return totalBlock;
	}





	public int getStartNum() {
		return startNum;
	}
	//Row 만들때 필요한 변수들.
	private int startNum;
	private int lastNum;
	
	public void makePage(int totalCount){
		//1. totalPage
		int totalPage = 0;
		int perBlock = 5; //기본 5개만 보여주자
		if(totalCount % this.getPerPage() == 0){
			totalPage = totalCount/this.getPerPage();
		}else{
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2.totalBlock
		if(totalPage%perBlock == 0){
			this.totalBlock = totalPage/perBlock;
		}else{
			this.totalBlock = totalPage/perBlock+1;
		}
		//3. curBlock
		if(this.getCurPage()%perBlock == 0){
			curBlock = this.getCurPage()/perBlock;
		}else{
			curBlock = this.getCurPage() /perBlock +1;
		}
		//4. startNum, lastNum
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		if(totalBlock == curBlock){
			lastNum =totalPage;
		}
	}
	
	
	
	
	
	public Integer getPerPage() {
		if(perPage == null){
			perPage= 10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getCurPage() {
		if(curPage==null){
			curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {

		this.curPage = curPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	public int getStartRow() {
		
		return startRow;
	}
	public int getLastRow() {
	
		return lastRow;
	}
	//Make Row  스타트 로우와 라스트 로우를 계산해줌.
	public void setRow(){
		//Null 이 올 수 있으니 위에서 getCurPage 할때 널일때 초기값 설정 했으니
		//this.getCurPage 를 호출한다.
		startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		lastRow = this.getCurPage()*this.getPerPage();
	}
	
	
}
