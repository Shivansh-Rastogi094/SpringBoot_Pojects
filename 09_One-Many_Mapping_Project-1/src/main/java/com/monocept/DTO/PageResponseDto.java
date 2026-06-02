package com.monocept.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto<T> {

	
	private List<T>content ;
	private int pageNumber,pageSize,totalPages; 
	private long totalElements; 
	private boolean lastPage; 
	
}
