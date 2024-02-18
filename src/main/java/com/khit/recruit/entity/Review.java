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
public class Review extends BaseEntity{
	
	@Id
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String title;
	
	@Column
	private String author;
	
	@Column
	private String content;

	@Column
	private String filename;

	@Column
	private String filepath;

	@Column
	private Integer likes;
	
	@Column
	private Integer views;

	@Column
	private Integer rating;


}
