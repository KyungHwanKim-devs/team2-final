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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String content;

	@Column
	private String filename;

	@Column
	private String filepath;

	@Column(nullable = false)
	private Integer likes;
	
	@Column(nullable = false)
	private Integer views;

	@Column(nullable = false)
	private Integer rating;


}
