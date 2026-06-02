package com.monocept.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDTO <T>{

	List<T> content;
	private int pageNumber,pageSize,totalPages;
	private boolean lastPage;
	private long totalElements;

}
