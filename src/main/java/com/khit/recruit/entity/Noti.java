package com.khit.recruit.entity;

import com.khit.recruit.dto.JobDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Currency;

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Noti extends BaseEntity{
	
	@Id
	@Column(name = "noti_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String author;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Integer likes;
	
	@Column(nullable = false)
	private Integer views;


	
}
