package com.subham.spring.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.subham.spring.entity.Student;
;
public class PageResponse {
	 private List<Student> students;
	    private int size;
	    
	    
		public List<Student> getStudents() {
			return students;
		}


		public void setStudents(List<Student> students) {
			this.students = students;
		}


		public int getSize() {
			return size;
		}


		public void setSize(int size) {
			this.size = size;
		}


		public PageResponse(int i, List<Student> list) {
			super();
			this.students = list;
			this.size = i;
		}
	    
}
