package org.jsp.em.responseStructure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseStructure<T> {
	private int status;
	private String message;
	private T body;
}
