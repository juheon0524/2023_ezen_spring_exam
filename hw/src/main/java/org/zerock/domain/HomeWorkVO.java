package org.zerock.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*create table tbl_homework (
	    id number(10,0),
	    name varchar2(200) not null,
	    age int,
	    birth date
	);*/

@Getter @Setter @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeWorkVO {
	private Long id;
	private String name;
	private int age;
	private String birth;
}
