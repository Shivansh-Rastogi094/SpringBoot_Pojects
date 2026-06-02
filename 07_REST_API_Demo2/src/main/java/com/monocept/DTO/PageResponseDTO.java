package com.monocept.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO<T> {

	
	private List<T>content;
	
	private int pageNum,pageSize,totalPages;

	long totalCount;
	private boolean lastPage;
//	public PageResponseDTO() {}
//	public PageResponseDTO(List<T> content, int pageNum, int pageSize, int totalPages, int totalCount,
//			boolean lastPage) {
//		this.content = content;
//		this.pageNum = pageNum;
//		this.pageSize = pageSize;
//		this.totalPages = totalPages;
//		this.totalCount = totalCount;
//		this.lastPage = lastPage;
//	}
//	public List<T> getContent() {
//		return content;
//	}
//	public void setContent(List<T> content) {
//		this.content = content;
//	}
//	public int getPageNum() {
//		return pageNum;
//	}
//	public void setPageNum(int pageNum) {
//		this.pageNum = pageNum;
//	}
//	public int getPageSize() {
//		return pageSize;
//	}
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//	public int getTotalPages() {
//		return totalPages;
//	}
//	public void setTotalPages(int totalPages) {
//		this.totalPages = totalPages;
//	}
//	public long getTotalCount() {
//		return totalCount;
//	}
//	public void setTotalCount1(long l) {
//		this.totalCount = l;
//	}
//	public boolean isLastPage() {
//		return lastPage;
//	}
//	public void setLastPage(boolean lastPage) {
//		this.lastPage = lastPage;
//	}
//	public void setTotalCount(long totalElements) {
//		// TODO Auto-generated method stub
//		
//	}
}
