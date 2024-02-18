package com.khit.recruit.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Free extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "free_id")
	private Long id;
	
	@Column
	private String title;

	@Column
	private String author;

	@Column
	private String content;
	
	@Column
	private Integer likes;
	
	@Column
	private Integer views;


	
}
